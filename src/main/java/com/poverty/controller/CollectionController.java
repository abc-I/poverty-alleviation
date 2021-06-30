package com.poverty.controller;

import com.poverty.entity.Result;
import com.poverty.entity.dto.CollectionDTO;
import com.poverty.service.CollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("/Collection")
@Api(tags = "收藏接口")
public class CollectionController {
    @Resource
    private CollectionService collectionService;
    @PostMapping("/insertCollection")
    @ApiOperation("添加收藏")
    public Result insertCollection(CollectionDTO collectionDTO){
        return collectionService.insertCollection(collectionDTO);
    }
    @PostMapping("/deleteCollection")
    @ApiOperation("取消收藏")
    public Result deleteCollection(CollectionDTO collectionDTO){
        return collectionService.deleteCollection(collectionDTO);
    }
}
