package com.dans.dansboot;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.dans.dansboot.entity.UserEntity;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = {"com.dans.dansboot.mapper"})
public class DansbootsLayuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DansbootsLayuiApplication.class, args);
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
    @RequestMapping("/index")
    public String index() {
        return "main";
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> list() {
        Map<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","success");
        map.put("count",15);
        List<UserEntity> list = new ArrayList<>();
        for (int i = 0 ;i<15;i++) {
            list.add(UserEntity.builder().id(i+"").username("user_"+i).build());
        }
        map.put("data",list);
     return map;
    }

    @RequestMapping("demo/table")
    public String table() {
        return "demo/tab";
    }

    @RequestMapping("demo/fromSelect")
    public String fromSelected() {
        return "demo/fromSelectDemo";
    }

    @RequestMapping("demo/tableSelected")
    public String tableSelected() {
        return "demo/tableselectDemo";
    }

    @RequestMapping("demo/test")
    public String test() {
        return "demo/test";
    }

}
