package com.poverty.mapper;

import com.poverty.entity.po.BeLike;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/7/1 10:06
 */
@Mapper
public interface BeLikeMapper {

    /**
     * 保存点赞
     *
     * @param beLike JSON{"id":"文章或视频id","userId":"用户id"}
     * @return boolean
     */
    boolean insertOne(BeLike beLike);

    /**
     * 判断是否点赞
     *
     * @param beLike JSON{"id":"文章或视频id","userId":"用户id"}
     * @return int
     */
    int selectOne(BeLike beLike);
}
