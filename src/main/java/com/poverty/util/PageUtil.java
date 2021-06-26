package com.poverty.util;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/17 20:15
 */
public class PageUtil {

    /**
     * 获取分页第一个index
     *
     * @param currentPage 当前页
     * @param pageSize 每页几条数据
     * @return int
     */
    public static int getStart(int currentPage, int pageSize) {
        return (currentPage - 1) * pageSize;
    }

    /**
     * 获取分页最后一个index
     *
     * @param currentPage 当前页
     * @param pageSize 每页几条数据
     * @return int
     */
    public static int getEnd(int currentPage, int pageSize) {
        return currentPage * pageSize;
    }

    /**
     * 获取共有几页
     *
     * @param total 总数居条数
     * @param pageSize 每页几条数据
     * @return int
     */
    public static int getPageCount(int total,int pageSize) {
        int pageCount = total / pageSize;

        return total % pageSize == 0 ? pageCount : pageCount + 1;
    }
}
