package com.poverty.service.impl;

import com.poverty.entity.Result;
import com.poverty.entity.dto.CollectionDTO;
import com.poverty.mapper.CollectionMapper;
import com.poverty.service.CollectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Resource
    private CollectionMapper collectionMapper;
    @Override
    public Result insertCollection(CollectionDTO collectionDTO) {
        boolean insertCollection = collectionMapper.insertCollection(collectionDTO);
        if(insertCollection){
            return Result.result200("收藏成功");
        }else {
            return Result.result500("收藏失败");
        }
    }

    @Override
    public Result deleteCollection(CollectionDTO collectionDTO) {
        boolean deleteCollection = collectionMapper.deleteCollection(collectionDTO);
        if(deleteCollection){
            return Result.result200("取消收藏成功");
        }else {
            return Result.result500("取消收藏失败");
        }
    }
}
