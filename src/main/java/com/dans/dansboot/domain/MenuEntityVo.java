package com.dans.dansboot.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuEntityVo implements Serializable {

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
