package com.manba.security.core.properties;

import com.alibaba.fastjson.JSON;

/**
 * descriptions: 响应返回结果集
 * author: clark
 * date: 2021-02-08
 */
public enum LoginResponseType {
    /**
     * 响应 JSON 字符串
     */
    JSON,
    /**
     * 重定向地址
     */
    REDIRECT
}
