package com.joyner.shiro.demo;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqy@xiaopeng.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class Demo1 extends B {

    public static void main(String[] args) {
        /**
         * Determines if the class or interface represented by this Class object is either the same as, or is a superclass or superinterface of, the class or interface represented by the specified Class parameter. It returns true if so; otherwise it returns false. If this Class object represents a primitive type, this method returns true if the specified Class parameter is exactly this Class object; otherwise it returns false.
         * Specifically, this method tests whether the type represented by the specified Class parameter can be converted to the type represented by this Class object via an identity conversion or via a widening reference conversion. See The Java Language Specification, sections 5.1.1 and 5.1.4 , for details.
         * Params:
         * cls – the Class object to be checked
         * Returns:
         * the boolean value indicating whether objects of the type cls can be assigned to objects of this class
         * Throws:
         * NullPointerException – if the specified Class parameter is null.
         * Since:
         * JDK1.1
         */
        Demo1 d = new Demo1();
        boolean assignableFrom = C.class.isAssignableFrom(Demo1.class);
        System.out.println(assignableFrom);

        Class<?> superclass = d.getClass().getSuperclass();
        System.out.println(superclass.getSimpleName());

    }
}

interface A {
}

class B extends C {
}

class C {

}