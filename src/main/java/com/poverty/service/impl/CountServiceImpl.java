package com.poverty.service.impl;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import com.poverty.mapper.CountMapper;
import com.poverty.service.CountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/29 12:42
 */
@Service
public class CountServiceImpl implements CountService {

    @Resource
    private CountMapper countMapper;

    /**
     * 审核未通过
     *
     * @param id 文章id
     * @return Result
     */
    @Override
    public Result noExaminedArticle(PostId id) {
        if (countMapper.updateNoExaminedById(id)) {
            return Result.result200("驳回成功！");
        } else {
            return Result.result500("驳回失败！");
        }
    }

    /**
     * 审核通过
     *
     * @param id 文章id
     * @return Result
     */
    @Override
    public Result isExaminedArticle(PostId id) {
        if (countMapper.updateIsExaminedById(id)) {
            return Result.result200("审核通过！");
        } else {
            return Result.result500("审核出错！");
        }
    }

}
