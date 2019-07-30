package com.dans.dansboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dans.dansboot.domain.vo.DictCodeAddVo;
import com.dans.dansboot.entity.DictCodeEntity;
import com.dans.dansboot.service.IDictCodeService;
import com.dans.dansboot.utils.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dictcode")
public class DictCodeController {

    @Autowired
    private IDictCodeService iDictCodeService;
    @PostMapping(value = "/list")
    public Result<IPage<DictCodeEntity>> list (
            @RequestParam(required = false,defaultValue = "1") Long page,
            @RequestParam(required = false,defaultValue = "10") Long limit,
            @RequestParam(required = false) String queryParam
    ) {
        IPage<DictCodeEntity> menuEntityIPage = iDictCodeService.pageAndQuery(page, limit,queryParam);
        return Result.ok(Result.CodeType.CODE_200,menuEntityIPage);
    }

    @PostMapping(value = "/add")
    public Result add (@RequestBody DictCodeAddVo addVo) {
        DictCodeEntity dictCodeEntity = DictCodeEntity.builder().status(1).build();
        BeanUtils.copyProperties(addVo, dictCodeEntity);
        iDictCodeService.save(dictCodeEntity);
        return Result.ok(Result.CodeType.CODE_200);
    }
}
