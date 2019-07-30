package com.dans.dansboot.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui/dictcode")
public class DictCodeUIController {

    @RequestMapping("list")
    public String list() {
        return "dict/list";
    }

    @RequestMapping("addAndUpdate")
    public String addAndUpdate() {
        return "dict/addAndUpdate";
    }


}
