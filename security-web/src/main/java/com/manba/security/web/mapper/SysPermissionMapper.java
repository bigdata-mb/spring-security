package com.manba.security.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.manba.security.web.entities.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: 408100209@qq.com
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {


    List<SysPermission> selectPermissionByUserId(@Param("userId") Long userId);

}
