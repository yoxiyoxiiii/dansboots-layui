package com.dans.dansboot.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("gencodeStep")
    public String gencodeStep(@RequestParam String tableName, Model model) {
        model.addAttribute("tableName",tableName);
        return "gencode/gencodeStep";
    }
}
