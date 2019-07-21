package com.dans.dansboot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dans.dansboot.entity.DictCodeEntity;
import com.dans.dansboot.mapper.DictCodeEntityMapper;
import com.dans.dansboot.service.IDictCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DictCodeServiceImpl extends ServiceImpl<DictCodeEntityMapper, DictCodeEntity> implements IDictCodeService {
    @Override
    public IPage<DictCodeEntity> pageAndQuery(Long page, Long limit, String queryParam) {
        IPage<DictCodeEntity> iPage = new Page<>(page,limit);
        return super.baseMapper.selectPage(iPage,null);
    }
}
