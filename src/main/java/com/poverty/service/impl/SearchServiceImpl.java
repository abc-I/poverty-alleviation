package com.poverty.service.impl;

import com.poverty.entity.Result;
import com.poverty.entity.po.SearchRecords;
import com.poverty.entity.vo.ArticlesVO;
import com.poverty.entity.vo.Page;
import com.poverty.mapper.ArticleMapper;
import com.poverty.mapper.SearchRecordsMapper;
import com.poverty.mapper.VideoMapper;
import com.poverty.service.SearchService;
import com.poverty.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/7/3 17:35
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private SearchRecordsMapper searchRecordsMapper;
    @Resource
    private VideoMapper videoMapper;

    @Override
    public Result searchArticleByTitle(String userId,String title, int current, int size) {
        int start = PageUtil.getStart(current, size);
        int end = PageUtil.getEnd(current, size);

        List<ArticlesVO> articles = articleMapper.selectArticleByTitle(title, start, end);
        int total = articleMapper.countByTitle(title);
        if (userId != null) {
            SearchRecords searchRecords = new SearchRecords();
            searchRecords.setSearchContent(title);
            searchRecords.setUserId(userId);

            searchRecordsMapper.insertOne(searchRecords);
        }

        return Result.result200(new Page(total, PageUtil.getPageCount(total, size), articles));
    }

    @Override
    public Result searchVideoByTitle(String userId, String title, int current, int size) {
        int start = PageUtil.getStart(current, size);
        int end = PageUtil.getEnd(current, size);

        List<ArticlesVO> articles = videoMapper.selectvideoByTitle(title, start, end);
        int total = videoMapper.countByTitle(title);
        if (userId != null) {
            SearchRecords searchRecords = new SearchRecords();
            searchRecords.setSearchContent(title);
            searchRecords.setUserId(userId);

            searchRecordsMapper.insertOne(searchRecords);
        }

        return Result.result200(new Page(total, PageUtil.getPageCount(total, size), articles));
    }
}