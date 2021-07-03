package com.poverty.service;

import com.poverty.entity.Result;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/7/3 17:34
 */
public interface SearchService {
    Result searchArticleByTitle(String userId,String title, int current, int size);

    Result searchVideoByTitle(String userId, String title, int current, int size);
}
