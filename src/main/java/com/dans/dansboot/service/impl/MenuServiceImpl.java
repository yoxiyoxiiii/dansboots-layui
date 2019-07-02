package com.dans.dansboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dans.dansboot.entity.MenuEntity;
import com.dans.dansboot.mapper.MenuEntityMapper;
import com.dans.dansboot.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MenuServiceImpl extends ServiceImpl<MenuEntityMapper,MenuEntity> implements MenuService {
}
