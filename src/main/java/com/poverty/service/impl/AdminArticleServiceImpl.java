package com.poverty.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import com.poverty.entity.vo.ArticleVO;
import com.poverty.entity.vo.ArticlesVO;
import com.poverty.mapper.ArticleMapper;
import com.poverty.mapper.CountMapper;
import com.poverty.service.AdminArticleService;
import com.poverty.util.PageUtil;
import org.bearer.entity.vo.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/28 9:11
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class AdminArticleServiceImpl implements AdminArticleService {

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private CountMapper countMapper;

    /**
     * 获取未审核的文章列表
     *
     * @param current 当前页
     * @param size 每页数据数
     * @return Result
     */
    @Override
    public Result getNotArticleList(int current, int size) {
        int start = PageUtil.getStart(current, size);
        int end = PageUtil.getEnd(current, size);

        List<ArticlesVO> articles = articleMapper.selectNotExaminedArticleList(start, end);
        int total = countMapper.countNotExamined();

        return Result.result200(new Page(total, PageUtil.getPageCount(total, size), articles));
    }

    /**
     * 获取通过审核的文章列表
     *
     * @param current 当前页
     * @param size 每页数据数
     * @return Result
     */
    @Override
    public Result getIsArticleList(int current, int size) {
        int start = PageUtil.getStart(current, size);
        int end = PageUtil.getEnd(current, size);

        List<ArticlesVO> articles = articleMapper.selectIsExaminedArticleList(start,end);
        int total = countMapper.countIsExamined();

        return Result.result200(new Page(total, PageUtil.getPageCount(total, size), articles));
    }

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

    /**
     * 获取审核未通过的文章
     *
     * @param id 文章id
     * @return Result
     */
    @Override
    public Result getNoArticle(String id) {
        ArticleVO articleVO = articleMapper.selectNotExaminedArticleById(id);
        return Result.result200(articleVO);
    }

    /**
     * 删除所有审核未通过的文章
     *
     * @return Result
     */
    @Override
    public Result deleteNoExamined() {
        try {
            List<String> ids = countMapper.selectIdsByNoExamined();
            if (articleMapper.deleteArticleByIds(ids) && countMapper.deleteByIds(ids)) {
                return Result.result200("删除成功！");
            }
            throw new Exception("Sql语句执行失败！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.result500("删除失败！");
        }
    }
}