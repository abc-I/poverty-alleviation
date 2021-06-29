package com.poverty.mapper;

import com.poverty.entity.dto.PostId;
import com.poverty.entity.vo.ArticleVO;
import com.poverty.entity.vo.ArticlesVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 16:03
 */
@Mapper
public interface ArticleMapper {
    List<ArticlesVO> selectNotExaminedArticleList(int start, int end);

    List<ArticlesVO> selectIsExaminedArticleList(int start, int end);

    boolean deleteArticleByIds(List<String> ids);

    ArticleVO selectNotExaminedArticleById(String id);
}
