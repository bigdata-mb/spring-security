package com.manba.security.core.authentication.session;

import com.manba.security.base.result.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.session.InvalidSessionStrategy;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * descriptions: 当session失效后的处理逻辑
 * author: clark
 * date: 2021-02-09
 */
public class CustomInvalidSessionStrategy implements InvalidSessionStrategy {
    Logger logger = LoggerFactory.getLogger(getClass());

    private SessionRegistry sessionRegistry;

    public CustomInvalidSessionStrategy(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("getSession().getId(): " + request.getSession().getId());
        logger.info("getRequestedSessionId(): " + request.getRequestedSessionId());
        sessionRegistry.removeSessionInformation(request.getRequestedSessionId());

        // 要将浏览器中的cookie的jsessionid删除
        cancelCookie(request, response);

        R result = new R().build(
                HttpStatus.UNAUTHORIZED.value(), "登录已超时，请重新登录");

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(result.toJsonString());
    }

    protected void cancelCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setMaxAge(0);
        cookie.setPath(getCookiePath(request));
        response.addCookie(cookie);
    }

    private String getCookiePath(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        return contextPath.length() > 0 ? contextPath : "/";
    }
}
