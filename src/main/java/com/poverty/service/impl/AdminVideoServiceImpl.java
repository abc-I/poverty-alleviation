package com.poverty.service.impl;

import com.poverty.entity.Result;
import com.poverty.entity.vo.VideoVO;
import com.poverty.entity.vo.VideosVO;
import com.poverty.mapper.CountMapper;
import com.poverty.mapper.VideoMapper;
import com.poverty.service.AdminVideoService;
import com.poverty.util.PageUtil;
import org.bearer.entity.vo.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/29 12:58
 */
@Service
public class AdminVideoServiceImpl implements AdminVideoService {

    @Resource
    private VideoMapper videoMapper;
    @Resource
    private CountMapper countMapper;

    /**
     * 获取所有未审核的视频
     *
     * @param current 当前页
     * @param size    每页数据数
     * @return Result
     */
    @Override
    public Result getNotVideoList(int current, int size) {
        return null;
//        int start = PageUtil.getStart(current, size);
//        int end = PageUtil.getEnd(current, size);
//
//        List<VideosVO> videos = videoMapper.selectNotExaminedVideoList(start, end);
//        int total = countMapper.countNotExaminedVideo();
//
//        return Result.result200(new Page(total, PageUtil.getPageCount(total, size), videos));
    }

    /**
     * 获取审核通过的视频列表
     *
     * @param current 当前页数
     * @param size 每页数据数
     * @return Result
     */
    @Override
    public Result getIsVideoList(int current, int size) {
        return null;
//        int start = PageUtil.getStart(current, size);
//        int end = PageUtil.getEnd(current, size);
//
//        List<VideosVO> videos = videoMapper.selectIsExaminedVideoList(start,end);
//        int total = countMapper.countIsExaminedVideo();
//
//        return Result.result200(new Page(total, PageUtil.getPageCount(total, size), videos));
    }

    /**
     * 获取未通过审核的视频列表
     *
     * @param current 当前页
     * @param size 每页数据数
     * @return Result
     */
    @Override
    public Result getNoVideoList(int current, int size) {
        return null;
//        int start = PageUtil.getStart(current, size);
//        int end = PageUtil.getEnd(current, size);
//
//        List<VideosVO> videos = videoMapper.selectNoExaminedVideoList(start, end);
//        int total = countMapper.countNoExaminedVideo();
//
//        return Result.result200(new Page(total, PageUtil.getPageCount(total, size), videos));
    }

    /**
     * 通过id获取视频
     *
     * @param id 视频id
     * @return Result
     */
    @Override
    public Result getVideoById(String id) {
        return null;
//        VideoVO videoVO = videoMapper.selectVideoById(id);
//        return Result.result200(videoVO);
    }
}
