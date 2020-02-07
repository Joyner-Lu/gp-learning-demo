package com.joyner.gp_learning.design_pattern.proxy.gpproxy;

import javafx.concurrent.Task;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Locale;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqingyun@foresee.cn
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class GPProxy {

    public static Object newProxyInstance(GPClassLoader loader,
                                          Class<?>[] interfaces,
                                          GPInvocationHandler h)
            throws IllegalArgumentException
    {
        try {
            //1.动态生成源代码文件
            String src = generateSrc(interfaces);

            //2.将文件输出到磁盘
            String filePath = GPProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileOutputStream outputStream = new FileOutputStream(f);
            outputStream.write(src.getBytes());
            outputStream.flush();
            outputStream.close();

            //3.将生成的java文件编译为class文件
            JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager standardJavaFileManager = javaCompiler.getStandardFileManager(null, Locale.CHINA, Charset.forName("UTF-8"));
            Iterable<? extends JavaFileObject>  iterable = standardJavaFileManager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = javaCompiler.getTask(null, standardJavaFileManager, null, null, null, iterable);
            task.call();
            standardJavaFileManager.close();

            //4.编译生成的class文件加载到JVM里面
            Class clz = loader.findClass("$Proxy0");
            Constructor constructor = clz.getConstructor(GPInvocationHandler.class);
            f.delete();

            return constructor.newInstance(h);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }


    }

    private static String generateSrc(Class<?>[] interfaces) {
        /**
         * 1.获取接口的方法，动态生成方法名称
         * 2.通过反射构造原来的方法为Method
         * 3.调用GPInvocationHandler的invoke方法
         */
        LineFeedStringBuilder lineFeedStringBuilder = new LineFeedStringBuilder();
        lineFeedStringBuilder.append("package com.joyner.gp_learning.design_pattern.proxy.gpproxy;");
        lineFeedStringBuilder.append("import java.lang.reflect.*;");
        lineFeedStringBuilder.append("public class $Proxy0 implements " + interfaces[0].getName() + "{");
            lineFeedStringBuilder.append("private GPInvocationHandler h;");

            lineFeedStringBuilder.append("public  $Proxy0(GPInvocationHandler h) {");
                lineFeedStringBuilder.append("this.h = h;");
            lineFeedStringBuilder.append("}");
            for (Method method : interfaces[0].getMethods()) {
                Class[] params = method.getParameterTypes();
                StringBuilder paramNames = new StringBuilder();
                StringBuilder paramClasses = new StringBuilder();
                StringBuilder paramValues = new StringBuilder();
                for (int i = 0; i < params.length; i++) {
                    Class clz = params[i];
                    String type = clz.getName();
                    String paramName = toLowerCaseFirstCase(clz.getSimpleName());
                    paramNames.append(type + " " + paramName);
                    paramClasses.append(type + ".class");
                    paramValues.append(paramName);
                    if (i != params.length - 1) {
                        paramNames.append(",");
                        paramClasses.append(",");
                        paramValues.append(",");
                    }

                }


                lineFeedStringBuilder.append("public " + method.getReturnType().getName() + " " + method.getName() + "(" + paramNames.toString() + ") {");
                    lineFeedStringBuilder.append("try {");
                        lineFeedStringBuilder.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + method.getName() + "\"," + "new Class[]{" + paramClasses +"});");
                        if (hasReturnVal(method.getReturnType())) {
                            lineFeedStringBuilder.append("return ("+method.getReturnType().getName()+") h.invoke(this, m,new Object[]{" + paramValues + "});");
                        } else {
                            lineFeedStringBuilder.append("h.invoke(this, m,new Object[]{" + paramValues + "});");
                        }
                    lineFeedStringBuilder.append("} catch(Throwable ex) {");
                        lineFeedStringBuilder.append("ex.printStackTrace();");
                        lineFeedStringBuilder.append("throw new RuntimeException(ex);");
                    lineFeedStringBuilder.append("}");
                lineFeedStringBuilder.append("}");
            }

        lineFeedStringBuilder.append("}");
        return lineFeedStringBuilder.toString();
    }

    private static String toLowerCaseFirstCase(String src) {
        char[] chars =src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    private static boolean hasReturnVal(Class clz) {
        return clz != void.class;
    }
}

class LineFeedStringBuilder {
    public static final String ln = "\r\n";
    private StringBuilder stringBuilder = new StringBuilder();

    public void append(String str) {
        stringBuilder.append(str + ln);
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
