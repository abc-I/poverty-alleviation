package com.poverty.service.impl;

import com.poverty.entity.Result;
import com.poverty.entity.po.Article;
import com.poverty.entity.po.BrowsingHistory;
import com.poverty.entity.vo.ArticleVO;
import com.poverty.entity.vo.ArticlesVO;
import com.poverty.entity.vo.Page;
import com.poverty.mapper.ArticleMapper;
import com.poverty.mapper.BrowsingHistoryMapper;
import com.poverty.mapper.CountMapper;
import com.poverty.service.ArticleService;
import com.poverty.util.PageUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/7/1 8:47
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private CountMapper countMapper;
    @Resource
    private BrowsingHistoryMapper browsingHistoryMapper;

    @Override
    public Result getArticleList(int current, int size) {
        int start = PageUtil.getStart(current, size);
        int end = PageUtil.getEnd(current, size);

        List<ArticlesVO> articles = articleMapper.selectIsExaminedArticleList(start, end);
        int total = countMapper.countIsExaminedArticle();

        return Result.result200(new Page(total, PageUtil.getPageCount(total, size), articles));
    }

    /**
     * 获取文章
     *
     * @param id 文章id
     * @return Result
     */
    @Override
    public Result getArticleById(String id, String userId) {
        ArticleVO article = articleMapper.getArticleById(id);
        countMapper.updateRecommendById(id);

        BrowsingHistory browsingHistory = new BrowsingHistory();
        browsingHistory.setUserId(userId);
        browsingHistory.setArticleId(id);

        browsingHistoryMapper.insertOne(browsingHistory);

        return Result.result200(article);
    }
}
