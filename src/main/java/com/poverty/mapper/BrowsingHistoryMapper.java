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
    void insertOne(BrowsingHistory browsingHistory);

    List<BrowsingHistoryVO> selectArticleBrowsingHistory(PostId userId);

    List<BrowsingHistoryVO> selectVideoBrowsingHistory(PostId userId);
}
