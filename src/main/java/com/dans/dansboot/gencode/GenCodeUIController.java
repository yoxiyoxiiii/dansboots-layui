package com.dans.dansboot.gencode;

import com.dans.dansboot.domain.dto.ColumnDto;
import com.dans.dansboot.gencode.GenCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

/**
 * 代碼生成工具
 */
@Controller
@RequestMapping("gencode")
public class GenCodeUIController {
    @Autowired
    private GenCodeService genCodeService;
    @RequestMapping("list")
    public String list() {
        return "gencode/list";
    }

    @RequestMapping("gencodeStep")
    public String gencodeStep(@RequestParam String tableName, Model model) throws SQLException {
        //指定表名获取类名
        List<ColumnDto> columnList = genCodeService.getColumnList(tableName);
        model.addAttribute("columnList",columnList);
        return "gencode/gencode";
    }
}
