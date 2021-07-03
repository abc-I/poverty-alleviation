package com.poverty.service.impl;

import com.poverty.entity.Result;
import com.poverty.entity.dto.BeLikeDTO;
import com.poverty.entity.dto.CollectionDTO;
import com.poverty.entity.po.BeLike;
import com.poverty.entity.vo.CollectionVO;
import com.poverty.entity.vo.Page;
import com.poverty.mapper.BeLikeMapper;
import com.poverty.mapper.CollectionMapper;
import com.poverty.mapper.CountMapper;
import com.poverty.service.CollectionService;
import com.poverty.util.PageUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zhu
 * @version 1.0
 * @date Created in 2021/6/30 11:05
 */
@Service
@Transactional(rollbackFor = {Exception.class})
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
    public Result collection(CollectionDTO collectionDTO) {
        int count = collectionMapper.count(collectionDTO);
        if(count > 0){
            boolean deleteCollection = collectionMapper.deleteCollection(collectionDTO);
            if (deleteCollection) {
                return Result.result200("取消收藏成功");
            } else {
                return Result.result500("取消收藏失败");
            }
        }
        boolean insertCollection = collectionMapper.insertCollection(collectionDTO);
        if (insertCollection) {
            return Result.result200("收藏成功");
        } else {
            return Result.result500("收藏失败");
        }
    }

    /**
     * 查询收藏
     *
     * @param userId 用户id
     * @return Result
     */
    @Override
    public Result selectArticleCollection(String userId,int current,int size) {
        int start = PageUtil.getStart(current, size);
        int end = PageUtil.getEnd(current, size);

        List<CollectionVO> selectCollection =
                collectionMapper.selectArticleCollection(userId, start, end);

        int total = collectionMapper.countArticleByUserId(userId);
        if (selectCollection.size() > 0) {
            return Result.result200(new Page(total, PageUtil.getPageCount(total, size), selectCollection));
        } else {
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
        BeLike beLike = new BeLike();
        beLike.setId(beLikeDTO.getId());
        beLike.setUserId(beLikeDTO.getUserId());
        if (beLikeMapper.count(beLike) > 0) {
            return Result.result200("点赞成功");
        }
        countMapper.updateBeLikedById(beLikeDTO.getId());

        boolean insertOne = beLikeMapper.insertOne(beLike);
        if (insertOne) {
            return Result.result200("点赞成功");
        } else {
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
        BeLike beLike = new BeLike();
        beLike.setId(id);
        beLike.setUserId(userId);
        return Result.result200(beLikeMapper.count(beLike));
    }

    /**
     * 查看视频收藏
     * @param userId
     * @return Result
     */
    @Override
    public Result selectVideoCollection(String userId,int current,int size) {
        int start = PageUtil.getStart(current, size);
        int end = PageUtil.getEnd(current, size);

        List<CollectionVO> selectCollection =
                collectionMapper.selectVideoCollection(userId, start, end);
        int total = collectionMapper.countVideoByUserId(userId);

        if (selectCollection.size() > 0) {
            return Result.result200(new Page(total, PageUtil.getPageCount(total, size), selectCollection));
        } else {
            return Result.result500("查询失败");
        }
    }
}
