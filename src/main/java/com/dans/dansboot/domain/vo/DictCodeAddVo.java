package com.dans.dansboot.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DictCodeAddVo {

    private String dictCode;
    private String codeName;
    private String createdBy;
    private String description;
}
