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

   private Result(CodeType code,String msg,boolean status, T data) {
       this.code = code.getCode();
       this.msg = msg;
       this.data = data;
       this.status = status;
   }
   private Result(int code,String msg,boolean status, T data) {
       this.code = code;
       this.msg = msg;
       this.data = data;
       this.status = status;
   }

   public  enum CodeType{
       DEFAULT_CODE(200),
       CODE_200(200),
       CODE_0(0),
       ;

       private int code;
       CodeType(int code) {
           this.code = code;
       }

       public int getCode() {
           return code;
       }
   }

   public static<T> Result<T> ok(T data, long count) {
       return new Result<>(CodeType.CODE_0,"ok",true, data);
   }

   public static<T> Result<T> ok(CodeType code ,T data) {
       if (StringUtils.isEmpty(code)) {
           return new Result<>(CodeType.CODE_200,"ok",true, data);
       }
       return new Result<>(code,"ok",true, data);
   }
   public static<T> Result<T> error(int code, String msg) {
       return new Result<>(code,msg,false,null);
   }

}
