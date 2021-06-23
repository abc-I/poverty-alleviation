package com.poverty.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/6/9 19:13
 */
@Data
public class Result implements Serializable {

    private static final long serialVersionUID = -6284491336589790385L;

    /**
     * 状态码
     */
    private int status;

    /**
     * 状态信息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object object;

    public Result(int status, String message, Object o) {
        this.status = status;
        this.message = message;
        this.object = o;
    }

    /**
     * 执行成功！
     *
     * @param o 返回数据
     * @return 返回结果
     */
    public static Result result200(Object o) {
        return new Result(200,"success!", o);
    }

    /**
     * 服务器内部错误！
     *
     * @param o 返回数据
     * @return 返回结果
     */
    public static Result result500(Object o) {
        return new Result(500, "Server internal error!", o);
    }

    /**
     * 拒绝访问！
     *
     * @param o 返回数据
     * @return 返回结果
     */
    public static Result result403(Object o) {
        return new Result(403,"Access denied!", o);
    }

    /**
     * 已删除!
     *
     * @param o 返回数据
     * @return 返回结果
     */
    public static Result result410(Object o) {
        return new Result(401,"Failed to pass the authentication!", o);
    }

    /**
     * 不支持的媒体类型！
     *
     * @param o 返回数据
     * @return 返回结果
     */
    public static Result result415(Object o) {
        return new Result(415, "Unsupported media type!", o);
    }

    /**
     * 未通过身份验证！
     *
     * @param o 返回数据
     * @return 返回结果
     */
    public static Result result401(Object o) {
        return new Result(401, "UNAUTHORIZED", o);
    }
}
