package com.dans.dansboot.gencode;

/**
 * mysql 数据库字段类型
 */
public enum MysqlColumnTypeEnum {

    VARCHAR("varchar"),
    CHAR("char"),
    TINYBLOB("tinyblob"),
    TINYTEXT("tinytext"),
    BLOB("blob"),
    TEXT("text"),
    MEDIUMBLOB("mediumblob"),
    MEDIUMTEXT("mediumtext"),
    LONGBLOB("longblob"),
    LONGTEXT("longtext"),
    DATE("date"),
    TIME("time"),
    YEAR("year"),
    DATETIME("datetime"),
    TIMESTAMP("timestamp"),
    INT("int"),
    TINYINT("tinyint"),
    SMALLINT("smallint"),
    MEDIUMINT("mediumint"),
    BIGING("bigint"),
    FLOAT("float"),
    DOUBLE("double"),

    ;

    private String type;
    MysqlColumnTypeEnum(String type) {
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
