package com.dans.dansboot;

import com.dans.dansboot.entity.UserEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SpringBootApplication
public class DansbootsLayuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DansbootsLayuiApplication.class, args);
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
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

}
