package com.dans.dansboot.utils;

import com.alibaba.fastjson.JSON;

public class JsonUtils {
    public static<T> T json2Bean(String jsonString, Class<T> clazz) {
        return JSON.parseObject(jsonString,clazz);
    }
}
