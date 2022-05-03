package com.joyner.gp_learning.spring_related.imitate_spring.framework.web.servlet;

import org.springframework.lang.Nullable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class GPView {

    private File templateFile;

    private final static String DEFAULT_CONTENT_TYPE = "text/html;charset=UTF-8";


    public GPView(File templateFile) {
        this.templateFile = templateFile;
    }

    /**
     * 开始渲染视图
     * @param model
     * @param request
     * @param response
     */
    public void render(Map<String, ?> model,
                HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType(DEFAULT_CONTENT_TYPE);
        try {
            StringBuilder sb = new StringBuilder();
            RandomAccessFile randomAccessFile = new RandomAccessFile(templateFile, "r");
            String lineText = randomAccessFile.readLine();
            while (lineText != null) {
                lineText = new String(lineText.getBytes("ISO-8859-1"), "UTF-8");
                //Pattern pattern = Pattern.compile("￥\\{([^\\}]+)\\}");
                Pattern pattern = null;
                Matcher matcher = pattern.matcher(lineText);
                while (matcher.find()) {
                    String key = matcher.group(1);
                    String strValForRegExp = makeStringForRegExp((String)model.get(key));
                    lineText = matcher.replaceFirst(strValForRegExp);
                    matcher = pattern.matcher(lineText);
                }
                sb.append(lineText);
                lineText = randomAccessFile.readLine();
            }
            response.getWriter().write(sb.toString());

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    //处理特殊字符
    public static String makeStringForRegExp(String str) {
        return str.replace("\\", "\\\\").replace("*", "\\*")
                .replace("+", "\\+").replace("|", "\\|")
                .replace("{", "\\{").replace("}", "\\}")
                .replace("(", "\\(").replace(")", "\\)")
                .replace("^", "\\^").replace("$", "\\$")
                .replace("[", "\\[").replace("]", "\\]")
                .replace("?", "\\?").replace(",", "\\,")
                .replace(".", "\\.").replace("&", "\\&");
    }

    public static void main(String[] args) {
        //Pattern pattern = Pattern.compile("￥\\{([^\\}]+)\\}");
        Pattern pattern = null;
        String result = "";
        Matcher matcher = pattern.matcher("￥{test}fdf}￥{fdfd}");
        while (matcher.find()) {

            String key = matcher.group(1);
            result = matcher.replaceFirst("123");
            matcher = pattern.matcher(result);
        }

        System.out.println(result);

    }
}
