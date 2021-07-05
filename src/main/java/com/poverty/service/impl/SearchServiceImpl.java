package com.poverty.service.impl;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import com.poverty.entity.po.SearchRecords;
import com.poverty.entity.vo.ArticlesVO;
import com.poverty.entity.vo.Page;
import com.poverty.entity.vo.VideosVO;
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

    /**
     * 搜索title的文章
     *
     * @param userId 用户id
     * @param title title的匹配
     * @param current 当前页
     * @param size 每页总数
     * @return Result
     */
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

    /**
     * 搜索title的视频
     *
     * @param userId 用户id
     * @param title title的匹配
     * @param current 当前页
     * @param size 每页总数
     * @return Result
     */
    @Override
    public Result searchVideoByTitle(String userId, String title, int current, int size) {
        int start = PageUtil.getStart(current, size);
        int end = PageUtil.getEnd(current, size);

        List<VideosVO> articles = videoMapper.selectVideoByTitle(title, start, end);
        int total = videoMapper.countByTitle(title);
        if (userId != null) {
            SearchRecords searchRecords = new SearchRecords();
            searchRecords.setSearchContent(title);
            searchRecords.setUserId(userId);

            searchRecordsMapper.insertOne(searchRecords);
        }

        return Result.result200(new Page(total, PageUtil.getPageCount(total, size), articles));
    }

    /**
     * 查询搜索记录
     *
     * @param userId 用户id
     * @return Result
     */
    @Override
    public Result searchRecords(String userId) {
        List<String> records = searchRecordsMapper.selectSearchRecords(userId);
        return Result.result200(records);
    }

    /**
     * 删除搜索记录
     *
     * @param id JSON{"id":"用户id"}
     * @return Result
     */
    @Override
    public Result deleteRecords(PostId id) {
        if (searchRecordsMapper.deleteByUserId(id)) {
            return Result.result200("删除成功！");
        } else {
            return Result.result500("删除失败！");
        }
    }
}
