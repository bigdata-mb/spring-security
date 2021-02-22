package com.manba.security.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.manba.security.web.entities.SysPermission;

import java.util.List;

/**
 * @Auther: 408100209@qq.com
 */
public interface SysPermissionService extends IService<SysPermission> {

    /**
     * 通过用户id查询所拥有权限
     * @param userId
     * @return
     */
    List<SysPermission> findByUserId(Long userId);

}
