package com.dans.dansboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dans.dansboot.domain.MenuEntityVo;
import com.dans.dansboot.entity.MenuEntity;
import com.dans.dansboot.mapper.MenuEntityMapper;
import com.dans.dansboot.service.MenuService;
import com.dans.dansboot.utils.Bean2MapUtils;
import com.dans.dansboot.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

@Slf4j
@Service
public class MenuServiceImpl extends ServiceImpl<MenuEntityMapper,MenuEntity> implements MenuService {

    /**
     * 分页查询
     * @param page 页数
     * @param limit 每页显示记录数
     * @param queryParams 查询条件
     * @return
     */
    @Override
    public IPage<MenuEntity> pageAndQuery(Long page, Long limit,String queryParams) {
        IPage<MenuEntity> ipage = new Page<>(page,limit);
        MenuEntityVo menuEntityVo = JsonUtils.json2Bean(queryParams, MenuEntityVo.class);
        QueryWrapper<MenuEntity> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(queryParams)) {
            Map<String, Object> queryMap = Bean2MapUtils.bean2Map(menuEntityVo);
            queryWrapper.allEq(queryMap);
        }
        return super.page(ipage,queryWrapper);
    }
}
