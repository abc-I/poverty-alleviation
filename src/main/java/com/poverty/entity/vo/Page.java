package org.bearer.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/17 20:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page implements Serializable {

    private static final long serialVersionUID = -6186268223091826019L;

    /**
     * 总条数
     */
    private Integer total;

    /**
     * 总页数
     */
    private Integer pageCount;

    /**
     * 数据
     */
    private Object object;
}
