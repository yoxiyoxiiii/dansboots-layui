package com.dans.dansboot.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 數據庫表信息
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TableDto implements Serializable {

    private String tableName;
    private String remark;
}
