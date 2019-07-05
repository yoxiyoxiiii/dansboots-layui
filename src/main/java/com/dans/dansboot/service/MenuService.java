package com.dans.dansboot.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dans.dansboot.entity.MenuEntity;

public interface MenuService extends IService<MenuEntity> {

    /**
     * 条件分页查询
     * @param page 页数
     * @param limit 每页显示记录数
     * @param queryParams 查询条件
     * @return
     */
    IPage<MenuEntity> pageAndQuery(Long page,Long limit, String queryParams);
}
