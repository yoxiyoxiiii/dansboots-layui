package com.dans.dansboot.gencode;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据库字段类型和 java 字段类型 映射关系
 */
public class TypeMapping {

    /**
     * 映射关系
     */
    private final Map<String,JavaFiledTypeEnum> typeMappingMap = new HashMap<>();
    {
        typeMappingMap.put(MysqlColumnTypeEnum.CHAR.getType(),JavaFiledTypeEnum.String);
        typeMappingMap.put(MysqlColumnTypeEnum.VARCHAR.getType(),JavaFiledTypeEnum.String);
        typeMappingMap.put(MysqlColumnTypeEnum.BLOB.getType(),JavaFiledTypeEnum.String);
        typeMappingMap.put(MysqlColumnTypeEnum.LONGBLOB.getType(),JavaFiledTypeEnum.String);
        typeMappingMap.put(MysqlColumnTypeEnum.LONGTEXT.getType(),JavaFiledTypeEnum.String);
        typeMappingMap.put(MysqlColumnTypeEnum.TEXT.getType(),JavaFiledTypeEnum.String);
        typeMappingMap.put(MysqlColumnTypeEnum.TINYTEXT.getType(),JavaFiledTypeEnum.String);
        typeMappingMap.put(MysqlColumnTypeEnum.MEDIUMBLOB.getType(),JavaFiledTypeEnum.String);
        typeMappingMap.put(MysqlColumnTypeEnum.BIGING.getType(),JavaFiledTypeEnum.Long);
        typeMappingMap.put(MysqlColumnTypeEnum.INT.getType(),JavaFiledTypeEnum.Integer);
        typeMappingMap.put(MysqlColumnTypeEnum.TINYINT.getType(),JavaFiledTypeEnum.Integer);
        typeMappingMap.put(MysqlColumnTypeEnum.FLOAT.getType(),JavaFiledTypeEnum.Float);
        typeMappingMap.put(MysqlColumnTypeEnum.DOUBLE.getType(),JavaFiledTypeEnum.Double);
        typeMappingMap.put(MysqlColumnTypeEnum.DATE.getType(),JavaFiledTypeEnum.Date);
        typeMappingMap.put(MysqlColumnTypeEnum.DATETIME.getType(),JavaFiledTypeEnum.Date);
        typeMappingMap.put(MysqlColumnTypeEnum.TIME.getType(),JavaFiledTypeEnum.Date);
        typeMappingMap.put(MysqlColumnTypeEnum.TIMESTAMP.getType(),JavaFiledTypeEnum.Date);
    }

    /**
     * 单例对象
     */
    private TypeMapping() {}
    private static volatile TypeMapping typeMapping;
    public static TypeMapping typeMapping() {
        if (typeMapping == null) {
            synchronized (TypeMapping.class) {
                if (typeMapping == null) {
                    typeMapping = new TypeMapping();
                }
            }
        }
        return typeMapping;
    }

    /**
     * 根据mysql 数据库类型 获取java 类型
     * @param mysqlType
     * @return
     */
    public JavaFiledTypeEnum javaFiledTypeEnum(String mysqlType) {
        return typeMappingMap.get(mysqlType);
    }
    
    
}
