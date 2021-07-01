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

    boolean insertOne(BeLike beLike);
}
