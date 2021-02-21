package com.manba.security.core.config;

import com.manba.security.core.authentication.mobile.SmsCodeSender;
import com.manba.security.core.authentication.mobile.SmsSend;
import com.manba.security.core.authentication.session.CustomInvalidSessionStrategy;
import com.manba.security.core.authentication.session.CustomSessionInformationExpiredStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 * descriptions: 主要为容器中添加Bean实例
 * author: clark
 * date: 2021 -02 -09
 */
@Configuration
public class SecurityConfigBean {


    @Bean
    @ConditionalOnMissingBean(SessionInformationExpiredStrategy.class)
    public SessionInformationExpiredStrategy sessionInformationExpiredStrategy() {
        return new CustomSessionInformationExpiredStrategy();
    }
    /**
     * 当session失效后的处理类
     * @return
     */
    @Autowired
    private SessionRegistry sessionRegistry;

    @Bean
    @ConditionalOnMissingBean(InvalidSessionStrategy.class)
    public InvalidSessionStrategy invalidSessionStrategy() {
        return new CustomInvalidSessionStrategy(sessionRegistry);
    }

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
