package com.dans.dansboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * 数据库字典值
 */
@Data
@Builder
@TableName(value = "sys_dict_data")
public class DictDataEntity {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String dictCode;
    private String dictName;
    private String dictValue;
    private Integer status;
}
