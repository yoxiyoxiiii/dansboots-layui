package com.dans.dansboot.gencode;

import com.dans.dansboot.domain.dto.ColumnDto;

/**
 * ColumnDto 包装类
 */
public class ColumnDtoDecorator {

    private final ColumnDto columnDto;
    public ColumnDtoDecorator(ColumnDto columnDto) {
        this.columnDto = columnDto;
    }

    public ColumnDto mysqlColumnType2JavaFiledType(String mysqlColumnType) {
        JavaFiledTypeEnum javaFiledTypeEnum = TypeMapping.typeMapping().javaFiledTypeEnum(mysqlColumnType.toLowerCase());
        columnDto.setJavaType(javaFiledTypeEnum.getType());
        return columnDto;
    }

}
