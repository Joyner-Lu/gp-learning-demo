package com.joyner.gp_learning.jvm_related.class_file_parse;

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
public enum ConstantPoolTypes {

    CONTANT_Utf8_info(1),CONSTANT_InterfaceMethodref_info(11),
    CONSTANT_String_info(8), CONSTANT_Integer_info(3),
    CONSTANT_Float_info(4),CONSTANT_Long_info(5),CONSTANT_Double_info(6)
    ,CONSTANT_NameAndType_info(12), CONSTANT_MethodHandle_info(15),CONSTANT_MethodType_info(16),
    CONSTANT_InvokeDynamic_info(18),CONSTANT_Methodref_info(10),CONSTANT_Fieldref_info(9),CONSTANT_Class_inf(7);
    private int accessFlagVal;

    private ConstantPoolTypes(int accessFlagVal) {
        this.accessFlagVal = accessFlagVal;
    }

    public int getAccessFlagVal() {
        return accessFlagVal;
    }

    public static ConstantPoolTypes getByAccessFlagVal(int accessFlagVal) {
        for (ConstantPoolTypes constantPoolType : values()) {
            if (accessFlagVal == constantPoolType.getAccessFlagVal()) {
                return constantPoolType;
            }
        }
        return null;
    }

}
