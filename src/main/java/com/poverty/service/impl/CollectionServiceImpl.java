package com.poverty.service.impl;

import com.poverty.entity.Result;
import com.poverty.entity.dto.BeLikeDTO;
import com.poverty.entity.dto.CollectionDTO;
import com.poverty.entity.po.BeLike;
import com.poverty.entity.po.Collection;
import com.poverty.mapper.BeLikeMapper;
import com.poverty.mapper.CollectionMapper;
import com.poverty.mapper.CountMapper;
import com.poverty.service.CollectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * @author Zhu
 * @version 1.0
 * @date Created in 2021/6/30 11:05
 */
@Service
public class CollectionServiceImpl implements CollectionService {
    @Resource
    private CollectionMapper collectionMapper;
    @Resource
    private BeLikeMapper beLikeMapper;
    @Resource
    private CountMapper countMapper;
    /**
     * 收藏
     *
     * @param collectionDTO
     * @return Result
     */
    @Override
    public Result insertCollection(CollectionDTO collectionDTO) {
        boolean insertCollection = collectionMapper.insertCollection(collectionDTO);
        if(insertCollection){
            return Result.result200("收藏成功");
        }else {
            return Result.result500("收藏失败");
        }
    }
    /**
     * 取消收藏
     *
     * @param collectionDTO
     * @return Result
     */
    @Override
    public Result deleteCollection(CollectionDTO collectionDTO) {
        boolean deleteCollection = collectionMapper.deleteCollection(collectionDTO);
        if(deleteCollection){
            return Result.result200("取消收藏成功");
        }else {
            return Result.result500("取消收藏失败");
        }
    }
    /**
     * 查询收藏
     *
     * @param userId 用户id
     * @return Result
     */
    @Override
    public Result selectCollection(String userId) {
        boolean selectCollection = collectionMapper.selectCollection(userId);
        if(selectCollection){
            return Result.result200("查询成功");
        }else {
            return Result.result500("查询失败");
        }
    }
    /**
     * 点赞
     *
     * @param beLikeDTO
     * @return Result
     */
    @Override
    public Result beLike(BeLikeDTO beLikeDTO) {
        BeLike beLike=new BeLike();
        beLike.setId(beLikeDTO.getId());
        beLike.setUserId(beLikeDTO.getUserId());
        countMapper.updateBeLikedById(beLikeDTO.getId());
        if (beLikeMapper.count(beLike)>0) {
            return Result.result200("点赞成功");
        }

        boolean insertOne = beLikeMapper.insertOne(beLike);
        if(insertOne){
            return Result.result200("点赞成功");
        }else {
            return Result.result500("点赞失败");
        }
    }
    /**
     * 查询点赞
     *
     * @param id,userid 文章或视频id和用户id
     * @return Result
     */
    @Override
    public Result selectBeLike(String id, String userId) {
        BeLike beLike=new BeLike();
        beLike.setId(id);
        beLike.setUserId(userId);
        return Result.result200(beLikeMapper.count(beLike));
    }
}
