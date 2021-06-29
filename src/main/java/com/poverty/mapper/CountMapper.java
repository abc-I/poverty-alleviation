package com.poverty.mapper;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 16:08
 */
@Mapper
public interface CountMapper {
    boolean deleteByIds(List<String> ids);

    boolean updateIsExaminedById(PostId id);

    boolean updateNoExaminedById(PostId id);

    int countNotExamined();

    int countIsExamined();

    List<String> selectIdsByNoExamined();
}
