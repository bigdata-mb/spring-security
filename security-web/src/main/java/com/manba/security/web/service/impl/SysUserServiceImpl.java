package com.manba.security.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manba.security.web.entities.SysUser;
import com.manba.security.web.mapper.SysUserMapper;
import com.manba.security.web.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @Auther: 408100209@qq.com
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public SysUser findByUsername(String username) {
        if(StringUtils.isEmpty(username)) {
            return null;
        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", username);
        // baseMapper 对应的是就是 SysUserMapper
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public SysUser findByMobile(String mobile) {
        if(StringUtils.isEmpty(mobile)) {
            return null;
        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("mobile", mobile);
        // baseMapper 对应的是就是 SysUserMapper
        return baseMapper.selectOne(queryWrapper);
    }


}
