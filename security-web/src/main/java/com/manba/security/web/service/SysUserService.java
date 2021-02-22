package com.manba.security.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.manba.security.web.entities.SysUser;

/**
 * IService<T> 提供了对T表操作的很多抽象方法，比如：批量操作，
 * @Auther: 408100209@qq.com
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 通过用户名查询用户信息
     * @param username 用户名
     * @return
     */
    SysUser findByUsername(String username) ;

    /**
     * 通过手机号查询用户信息
     * @param mobile 手机号
     * @return
     */
    SysUser findByMobile(String mobile);
}
