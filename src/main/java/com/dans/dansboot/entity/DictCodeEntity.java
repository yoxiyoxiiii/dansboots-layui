package com.dans.dansboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * 数据库字典类型
 */
@Data
@Builder
@TableName(value = "sys_dict_code")
public class DictCodeEntity  {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String dictCode;
    private String codeName;
    private Integer status;
    private String description;
    private String createdBy;

}