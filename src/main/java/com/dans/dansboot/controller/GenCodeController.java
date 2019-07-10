package com.dans.dansboot.controller;

import com.dans.dansboot.domain.dto.ColumnDto;
import com.dans.dansboot.domain.dto.TableDto;
import com.dans.dansboot.gencode.GenCodeService;
import com.dans.dansboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/gencode")
public class GenCodeController {

    @Autowired
    private GenCodeService genCodeService;

    @GetMapping("list")
    public Result<List<TableDto>> list() throws SQLException {
        List<TableDto> tableList = genCodeService.getTableList();
        return Result.ok(tableList, tableList.size());
    }

    @GetMapping("columnList")
    public Result<List<ColumnDto>> columnList(String tableName) throws SQLException {
        List<ColumnDto> columnList = genCodeService.getColumnList(tableName);
        return Result.ok(columnList, columnList.size());
    }
}
