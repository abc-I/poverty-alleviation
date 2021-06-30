package com.poverty.service;

import com.poverty.entity.Result;
import com.poverty.entity.dto.CollectionDTO;

public interface CollectionService {
    Result insertCollection(CollectionDTO collectionDTO);

    Result deleteCollection(CollectionDTO collectionDTO);
}
