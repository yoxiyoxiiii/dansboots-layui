package com.dans.dansboot.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 表的列信息
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColumnDto implements Serializable {

    //列名
    private String name;
    //類型
    private String type;
    //注解
    private String remarks;
}
