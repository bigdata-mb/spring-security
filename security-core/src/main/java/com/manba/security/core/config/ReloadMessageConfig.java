package com.manba.security.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * descriptions:
 * author: clark
 * date: 2021-02-08
 */
@Configuration
public class ReloadMessageConfig {

    @Bean // 加载中文的认证提示信息
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new
                ReloadableResourceBundleMessageSource();
        //.properties 不要加到后面
        messageSource.setBasename("classpath:org/springframework/security/messages_zh_CN");
        return messageSource;
    }
}
