package com.dans.dansboot.utils;

import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * 结果集返回
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {
   private T data;
   private String msg;
   private int code;
   private boolean status;

   private Result(int code,String msg,boolean status, T data) {
       this.code = code;
       this.msg = msg;
       this.data = data;
       this.status = status;
   }

   public static<T> Result<T> ok(T data, long count) {
       return new Result<>(0,"ok",true, data);
   }

   public static<T> Result<T> ok(Integer code ,T data) {
       if (StringUtils.isEmpty(code)) {
           return new Result<>(200,"ok",true, data);
       }
       return new Result<>(code,"ok",true, data);
   }
   public static<T> Result<T> error(int code, String msg) {
       return new Result<>(code,msg,false,null);
   }

}
