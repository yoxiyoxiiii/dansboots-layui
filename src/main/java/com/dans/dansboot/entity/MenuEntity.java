package com.dans.dansboot.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class MenuEntity implements Serializable {

    private String id;
    private String name;
    private String url;
    private Integer level;
    private String pid;
    private String path;
}
