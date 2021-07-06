package com.poverty.service.impl;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import com.poverty.entity.vo.BrowsingHistoryVO;
import com.poverty.entity.vo.Page;
import com.poverty.mapper.BrowsingHistoryMapper;
import com.poverty.service.BrowsingHistoryService;
import com.poverty.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author Zhu
 * @version 1.0
 * @date Created in 2021/7/4 9:27
 */
@Service
public class BrowsingHistoryServiceImpl implements BrowsingHistoryService {
    @Resource
    private BrowsingHistoryMapper browsingHistoryMapper;

    /**
     * 查找文章历史记录
     *
     * @param userId
     * @return Result
     */
    @Override
    public Result selectArticleBrowsingHistory(String userId, int current, int size) {
        int start = PageUtil.getStart(current, size);
        int end = PageUtil.getEnd(current, size);

        List<BrowsingHistoryVO> articleBrowsingHistoryVOS =
                browsingHistoryMapper.selectArticleBrowsingHistory(userId, start, end);
        int total = browsingHistoryMapper.countArticle(userId);

        if (articleBrowsingHistoryVOS.size() > 0) {
            return Result.result200(
                    new Page(total, PageUtil.getPageCount(total, size), articleBrowsingHistoryVOS));
        } else {
            return Result.result500("查询失败");
        }
    }

    /**
     * 查找视频历史记录
     *
     * @param userId
     * @return Result
     */
    @Override
    public Result selectVideoBrowsingHistory(String userId, int current, int size) {
        int start = PageUtil.getStart(current, size);
        int end = PageUtil.getEnd(current, size);

        List<BrowsingHistoryVO> videoBrowsingHistoryVOS =
                browsingHistoryMapper.selectVideoBrowsingHistory(userId, start, end);
        int total = browsingHistoryMapper.countVideo(userId);

        if (videoBrowsingHistoryVOS.size() > 0) {
            return Result.result200(
                    new Page(total, PageUtil.getPageCount(total, size), videoBrowsingHistoryVOS));
        } else {
            return Result.result500("查询失败");
        }
    }

    /**
     * 删除文章历史记录
     * @param userId
     * @return Result
     */
    @Override
    public Result deleteArticleBrowsingHistory(PostId userId) {
        boolean deleteArticleBrowsingHistory = browsingHistoryMapper.deleteArticleBrowsingHistory(userId);
        if (deleteArticleBrowsingHistory){
            return Result.result200("删除成功");
        }else {
            return Result.result500("删除失败");
        }
    }

    /**
     * 删除视频历史记录
     * @param userId
     * @return Result
     */
    @Override
    public Result deleteVideoBrowsingHistory(PostId userId) {
        boolean deleteVideoBrowsingHistory = browsingHistoryMapper.deleteVideoBrowsingHistory(userId);
        if (deleteVideoBrowsingHistory){
            return Result.result200("删除成功");
        }else {
            return Result.result500("删除失败");
        }
    }
}
