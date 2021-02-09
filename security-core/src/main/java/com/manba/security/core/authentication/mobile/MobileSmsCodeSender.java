package com.manba.security.core.authentication.mobile;

import org.springframework.stereotype.Component;

/**
 * descriptions: 替换默认实现 SmsCodeSender
 * author: clark
 * date: 2021-02-09
 */
// @Component
public class MobileSmsCodeSender implements SmsSend{

    @Override
    public boolean sendSms(String mobile, String content) {
        return false;
    }
}
