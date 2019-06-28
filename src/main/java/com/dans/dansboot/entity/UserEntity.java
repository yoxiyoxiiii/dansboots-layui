package com.dans.dansboot.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserEntity implements Serializable {
    private String id;
    private String username;
    private String sex;
    private String city;
    private String sign;
    private String experience;
    private String score;
    private String classify;
    private String wealth;
}
