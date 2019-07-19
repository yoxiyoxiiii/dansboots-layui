package com.dans.dansboot.gencode;

/**
 * 字段类型
 */
public enum JavaFiledTypeEnum {

    String("java.lang.String"),
    Integer("java.lang.Integer"),
    Long("java.lang.Long"),
    Double("java.lang.Double"),
    Float("java.lang.Float"),
    Date("java.util.Date"),
    ;

    private String type;
    JavaFiledTypeEnum(String type) {
        this.type = type;
    }

    public java.lang.String getType() {
        return type;
    }

    public void setType(java.lang.String type) {
        this.type = type;
    }
}
