package com.cy.store.config;

import com.cy.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/** 处理器拦截器的注册 */
@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    // 将自定义的拦截器进行注册
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 创建自定义的拦截器对象
        HandlerInterceptor interceptor = new LoginInterceptor();
        // 配置白名单：村房子啊一个list集合中
        List<String> patterns = new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        patterns.add("/web/index.html");
        patterns.add("/web/product.html");
        patterns.add("/users/register");
        patterns.add("/users/login");
        patterns.add("/districts/**");
        patterns.add("/products/**");


        // 完成拦截器的注册
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(patterns);
    }

}
