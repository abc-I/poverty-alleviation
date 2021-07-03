package com.poverty.service;

import com.poverty.entity.Result;
import com.poverty.entity.dto.PostId;

public interface BrowsingHistoryService {
    Result selectArticleBrowsingHistory(PostId userId);

    Result selectVideoBrowsingHistory(PostId userId);
}
