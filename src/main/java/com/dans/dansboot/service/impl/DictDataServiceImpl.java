package com.dans.dansboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dans.dansboot.entity.DictDataEntity;
import com.dans.dansboot.mapper.DictDataEntityMapper;
import com.dans.dansboot.service.IDictDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DictDataServiceImpl extends ServiceImpl<DictDataEntityMapper, DictDataEntity> implements IDictDataService {
}
