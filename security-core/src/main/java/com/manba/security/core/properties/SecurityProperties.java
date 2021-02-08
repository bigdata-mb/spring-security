package com.manba.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * descriptions:
 * author: clark
 * date: 2021-02-08
 */
@Component
@ConfigurationProperties(prefix = "manba.security")
public class SecurityProperties {

    private AuthenticationProperties authentication;

    public AuthenticationProperties getAuthentication() {
        return authentication;
    }

    public void setAuthentication(AuthenticationProperties authentication) {
        this.authentication = authentication;
    }
}
