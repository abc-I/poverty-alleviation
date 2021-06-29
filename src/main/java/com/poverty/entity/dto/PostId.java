package com.poverty.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/26 14:09
 */
@Data
public class PostId implements Serializable {
    private static final long serialVersionUID = 7699205756645688693L;

    /**
     * id
     */
    private String id;
}
