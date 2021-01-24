package com.community.config;

import com.community.controller.interceptor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private LoginTicketInterceptor loginTicketInterceptor;

//    @Autowired //使用Security，不适用自己配的
//    private LoginRequiredInterceptor loginRequiredInterceptor;
    @Autowired
    private DataInterceptor dataInterceptor;
    @Autowired
    private MessageInterceptor messageInterceptor;
    @Override//具体解决是把/**/*.html 改为 /*/*.html，项目中可能涉及多个文件，都要改。
    public void addInterceptors(InterceptorRegistry registry) {//注入拦截器
        registry.addInterceptor(loginTicketInterceptor)
                .excludePathPatterns("/*/*.css", "/*/*.js", "/*/*.png", "/*/*.jpg", "/*/*.jpeg");

//        //不要拦截这些静态资源
//        registry.addInterceptor(loginRequiredInterceptor)
//                .excludePathPatterns("/*/*.css", "/*/*.js", "/*/*.png", "/*/*.jpg", "/*/*.jpeg");


        registry.addInterceptor(messageInterceptor)
                .excludePathPatterns("/*/*.css", "/*/*.js", "/*/*.png", "/*/*.jpg", "/*/*.jpeg");

        registry.addInterceptor(dataInterceptor)
                .excludePathPatterns("/*/*.css", "/*/*.js", "/*/*.png", "/*/*.jpg", "/*/*.jpeg");
    }

}
