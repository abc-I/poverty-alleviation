package com.poverty.util;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/17 20:15
 */
public class PageUtil {

    public static int getStart(int currentPage, int pageSize) {
        return (currentPage - 1) * pageSize;
    }

    public static int getEnd(int currentPage, int pageSize) {
        return currentPage * pageSize;
    }

    public static int getPageCount(int total,int pageSize) {
        int pageCount = total / pageSize;

        return total % pageSize == 0 ? pageCount : pageCount + 1;
    }
}
