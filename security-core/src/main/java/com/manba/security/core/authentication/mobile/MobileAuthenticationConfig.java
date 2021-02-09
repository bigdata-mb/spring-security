package com.manba.security.core.authentication.mobile;

import com.manba.security.core.authentication.CustomAuthenticationFailureHandler;
import com.manba.security.core.authentication.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * descriptions: 用于组合其他关于手机登录的组件
 * author: clark
 * date: 2021 -02 -09
 */
@Component
public class MobileAuthenticationConfig
        extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {


    @Autowired
    CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Autowired
    UserDetailsService mobileUserDetailsService;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        MobileAuthenticationFilter mobileAuthenticationFilter = new MobileAuthenticationFilter();
        // 获取容器中已经存在的AuthenticationManager对象，并传入 mobileAuthenticationFilter 里面
        mobileAuthenticationFilter.setAuthenticationManager(
                http.getSharedObject(AuthenticationManager.class));

        // 指定记住我功能
        mobileAuthenticationFilter.setRememberMeServices(http.getSharedObject(RememberMeServices.class));

        // 传入 失败与成功处理器
        mobileAuthenticationFilter.setAuthenticationSuccessHandler(customAuthenticationSuccessHandler);
        mobileAuthenticationFilter.setAuthenticationFailureHandler(customAuthenticationFailureHandler);

        // 构建一个MobileAuthenticationProvider实例，接收 mobileUserDetailsService 通过手机号查询用户信息
        MobileAuthenticationProvider provider = new MobileAuthenticationProvider();
        provider.setUserDetailsService(mobileUserDetailsService);

        // 将provider绑定到 HttpSecurity上，并将 手机号认证过滤器绑定到用户名密码认证过滤器之后
        http.authenticationProvider(provider)
                .addFilterAfter(mobileAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    }
}