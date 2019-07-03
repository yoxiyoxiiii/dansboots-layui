package com.dans.dansboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dans.dansboot.entity.MenuEntity;
import com.dans.dansboot.service.MenuService;
import com.dans.dansboot.utils.Result;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 功能接口
 */
@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/list")
    public Result<IPage<MenuEntity>> list () {
        IPage<MenuEntity> page = new Page<>();
        IPage<MenuEntity> menuEntityIPage = menuService.page(page);
        return Result.ok(menuEntityIPage);
    }
}
