package com.poverty.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/28 19:49
 */
@Data
public class ArticleVO implements Serializable {
    private static final long serialVersionUID = -1010822801619179404L;

    private String id;
    private String title;
    private String articleUrl;
    private String username;
    private Integer recommend;
    private Integer beLiked;
    private Date createTime;
}
