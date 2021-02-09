package com.manba.security.core.properties;


/**
 * descriptions:
 * author: clark
 * date: 2021 -02 -08
 */

public class AuthenticationProperties {
    private String loginPage = "/login/page";
    private String loginProcessingUrl = "/login/form";
    private String usernameParameter = "name";
    private String passwordParameter = "pwd";
    private String[] staticPaths = {"/dist/**", "/modules/**", "/plugins/**"};

    /**
     * 登录成功后响应 JSON , 还是重定向
     * 如果application.yml 中没有配置，则取此初始值 REDIRECT   
     */
    private LoginResponseType loginType = LoginResponseType.REDIRECT;

    /**
     *   * 获取图形验证码 url
     *   
     */
    private String imageCodeUrl = "/code/image";
    /**
     *  * 发送手机验证码 url
     *  
     */
    private String mobileCodeUrl = "/code/mobile";
    /**
     *  * 前往手机登录页面地址
     *  
     */
    private String mobilePage = "/mobile/page";
    /**
     *  * 记住我有效时长
     *  
     */
    private Integer tokenValiditySeconds = 60 * 60 * 24 * 7;

    public String getImageCodeUrl() {
        return imageCodeUrl;
    }

    public void setImageCodeUrl(String imageCodeUrl) {
        this.imageCodeUrl = imageCodeUrl;
    }

    public String getMobileCodeUrl() {
        return mobileCodeUrl;
    }

    public void setMobileCodeUrl(String mobileCodeUrl) {
        this.mobileCodeUrl = mobileCodeUrl;
    }

    public String getMobilePage() {
        return mobilePage;
    }

    public void setMobilePage(String mobilePage) {
        this.mobilePage = mobilePage;
    }

    public Integer getTokenValiditySeconds() {
        return tokenValiditySeconds;
    }

    public void setTokenValiditySeconds(Integer tokenValiditySeconds) {
        this.tokenValiditySeconds = tokenValiditySeconds;
    }

    public LoginResponseType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginResponseType loginType) {
        this.loginType = loginType;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public String getLoginProcessingUrl() {
        return loginProcessingUrl;
    }

    public void setLoginProcessingUrl(String loginProcessingUrl) {
        this.loginProcessingUrl = loginProcessingUrl;
    }

    public String getUsernameParameter() {
        return usernameParameter;
    }

    public void setUsernameParameter(String usernameParameter) {
        this.usernameParameter = usernameParameter;
    }

    public String getPasswordParameter() {
        return passwordParameter;
    }

    public void setPasswordParameter(String passwordParameter) {
        this.passwordParameter = passwordParameter;
    }

    public String[] getStaticPaths() {
        return staticPaths;
    }

    public void setStaticPaths(String[] staticPaths) {
        this.staticPaths = staticPaths;
    }
}
