package com.joyner.gp_learning.java_basic.type_learning;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

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
public class TestHelper {

    public static void main(String[] args) {
        testParameterizedType();
    }

    public static void testParameterizedType() {
        Field f = null;
        try {
            Field[] fields = ParameterizedTypeBean.class.getDeclaredFields();
            // 打印出所有的 Field 的 TYpe 是否属于 ParameterizedType
            for (int i = 0; i < fields.length; i++) {
                f = fields[i];
                PrintUtils.print(f.getName()
                        + " getGenericType() instanceof ParameterizedType "
                        + (f.getGenericType() instanceof ParameterizedType));
            }
            getParameterizedTypeMes("map" );
            getParameterizedTypeMes("entry" );


        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static void getParameterizedTypeMes(String fieldName) throws NoSuchFieldException {
        Field f;
        f = ParameterizedTypeBean.class.getDeclaredField(fieldName);
        f.setAccessible(true);
        PrintUtils.print(f.getGenericType());
        boolean b=f.getGenericType() instanceof ParameterizedType;
        PrintUtils.print(b);
        if(b){
            ParameterizedType pType = (ParameterizedType) f.getGenericType();
            PrintUtils.print(pType.getRawType());
            for (Type type : pType.getActualTypeArguments()) {
                PrintUtils.print(type);
            }
            PrintUtils.print(pType.getOwnerType()); // null
        }
    }
}
