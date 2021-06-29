package com.poverty.service;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/29 12:42
 */
public interface CountService {

    /**
     * 审核未通过
     *
     * @param id 文章id
     * @return Result
     */
    Result noExaminedArticle(PostId id);

    /**
     * 审核通过
     *
     * @param id 文章id
     * @return Result
     */
    Result isExaminedArticle(PostId id);
}
