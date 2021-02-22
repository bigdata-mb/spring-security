package com.manba.security.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manba.security.web.entities.SysPermission;
import com.manba.security.web.mapper.SysPermissionMapper;
import com.manba.security.web.service.SysPermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 408100209@qq.com
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {
    
    
    @Override
    public List<SysPermission> findByUserId(Long userId) {
        if(userId == null) {
            return null;
        }
        List<SysPermission> permissionList = baseMapper.selectPermissionByUserId(userId);
        // 如果没有权限，则将集合中的数据null移除
//        permissionList.remove(null);
        return permissionList;
    }
    
}
