package com.poverty.service.impl;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;
import com.poverty.entity.vo.BrowsingHistoryVO;
import com.poverty.mapper.BrowsingHistoryMapper;
import com.poverty.service.BrowsingHistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Override
    public Result selectArticleBrowsingHistory(PostId userId) {
        List<BrowsingHistoryVO> articleBrowsingHistoryVOS = browsingHistoryMapper.selectArticleBrowsingHistory(userId);
        if(articleBrowsingHistoryVOS.size()>0){
            return Result.result200(articleBrowsingHistoryVOS);
        }else {
            return Result.result500("查询失败");
        }
    }

    @Override
    public Result selectVideoBrowsingHistory(PostId userId) {
        List<BrowsingHistoryVO> videoBrowsingHistoryVOS = browsingHistoryMapper.selectVideoBrowsingHistory(userId);
        if(videoBrowsingHistoryVOS.size()>0){
            return Result.result200(videoBrowsingHistoryVOS);
        }else {
            return Result.result500("查询失败");
        }
    }
}