package com.dans.dansboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@TableName(value = "sys_menu")
public class MenuEntity implements Serializable {

  @TableId(type = IdType.ID_WORKER)
  private String id;
  private String name;
  private String url;
  private Integer level;
  private String pid;
  private String path;
  private Integer type;
  private String icon;
  private Date createTime;
  private Date updateTime;

}
