package com.dans.dansboot.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 界面跳转
 */
@Controller
@RequestMapping("menu")
public class MenuUIController {

    @RequestMapping("list")
    public String list() {
//        return "menu/list";
        return "menu/treeList";
    }

}
