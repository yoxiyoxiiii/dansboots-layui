package com.dans.dansboot.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 代碼生成工具
 */
@Controller
@RequestMapping("gencode")
public class GenCodeUIController {
    @RequestMapping("list")
    public String list() {
        return "gencode/list";
    }
}
