package com.manba.security.core.config;

import com.manba.security.core.authentication.mobile.SmsCodeSender;
import com.manba.security.core.authentication.mobile.SmsSend;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * descriptions: 主要为容器中添加Bean实例
 * author: clark
 * date: 2021 -02 -09
 */
@Configuration
public class SecurityConfigBean {
    /**
     * @ConditionalOnMissingBean(SmsSend.class)
     * 默认情况下，采用的是SmsCodeSender实例 ，
     * 但是如果容器当中有其他的SmsSend类型的实例，
     * 那当前的这个SmsCodeSender就失效 了
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(SmsSend.class)
    public SmsSend smsSend() {
        return new SmsCodeSender();
    }
}
