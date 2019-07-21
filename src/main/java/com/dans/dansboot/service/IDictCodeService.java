package com.dans.dansboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dans.dansboot.entity.DictCodeEntity;

public interface IDictCodeService extends IService<DictCodeEntity> {
    IPage<DictCodeEntity> pageAndQuery(Long page, Long limit, String queryParam);
}
