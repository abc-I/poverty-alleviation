package com.poverty.mapper;

import com.poverty.entity.dto.PostId;
import com.poverty.entity.po.BrowsingHistory;
import com.poverty.entity.vo.BrowsingHistoryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/23 16:08
 */
@Mapper
public interface BrowsingHistoryMapper {
    /**
     * 增加一条历史记录
     *
     * @param browsingHistory
     * @return void
     */
    void insertOne(BrowsingHistory browsingHistory);

    /**
     * 查询文章历史记录
     *
     * @param userId 用户id
     * @return List<BrowsingHistoryVO>
     */
    List<BrowsingHistoryVO> selectArticleBrowsingHistory(String userId, int start, int end);

    /**
     * 查询视频历史记录
     *
     * @param userId 用户id
     * @return List<BrowsingHistoryVO>
     */
    List<BrowsingHistoryVO> selectVideoBrowsingHistory(String userId, int start, int end);
    /**
     * 删除文章历史记录
     *
     * @param userId   用户id
     * @return boolean
     */
    boolean deleteArticleBrowsingHistory(PostId userId);
    /**
     * 删除视频历史记录
     *
     * @param userId   用户id
     * @return boolean
     */
    boolean deleteVideoBrowsingHistory(PostId userId);

    /**
     * 统计收藏的文章
     *
     * @param userId 用户id
     * @return int
     */
    int countArticle(String userId);

    /**
     * 统计收藏的视频
     *
     * @param userId 用户id
     * @return int
     */
    int countVideo(String userId);
}
