package com.dans.dansboot.utils;

import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Bean2MapUtils {

    public static<T> Map<String, Object> bean2Map(T entity) {
        Class<?> aClass = entity.getClass();
        Map<String,Object> resultMap = new HashMap<>();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field filed : declaredFields ) {
            filed.setAccessible(true);
            String name = filed.getName();
            try {
                Object value = filed.get(entity);
                //属性值不为空
                if (!StringUtils.isEmpty(value)) {
                    resultMap.put(name,value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return resultMap;
    }
}
