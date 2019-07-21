package com.dans.dansboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dans.dansboot.entity.MenuEntity;
import com.dans.dansboot.service.IMenuService;
import com.dans.dansboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 功能接口
 */
@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @PostMapping(value = "/list")
    public Result<IPage<MenuEntity>> list (@RequestParam(required = false,defaultValue = "1") Long page,
                                           @RequestParam(required = false,defaultValue = "10") Long limit,
                                           @RequestParam(required = false) String queryParam
                                           ) {
        IPage<MenuEntity> menuEntityIPage = menuService.pageAndQuery(page, limit,queryParam);
        return Result.ok(null,menuEntityIPage);
    }

    @GetMapping(value = "/treelist")
    public Result<List<MenuEntity>> treelist (@RequestParam(required = false,defaultValue = "1") Long page,
                                              @RequestParam(required = false,defaultValue = "10") Long limit,
                                              @RequestParam(required = false) String queryParam
                                           ) {
        IPage<MenuEntity> menuEntityIPage = menuService.pageAndQuery(page, limit,queryParam);
        return Result.ok(Result.CodeType.CODE_0,menuEntityIPage.getRecords());
    }
}
