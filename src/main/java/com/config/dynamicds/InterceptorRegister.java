package com.config.dynamicds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class InterceptorRegister implements WebMvcConfigurer{
	@Autowired
	private OrgCodeInterceptor orgCodeInterceptor;
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration addInterceptor = registry.addInterceptor(orgCodeInterceptor);
        addInterceptor.excludePathPatterns("/error");
        addInterceptor.excludePathPatterns("/static/**");//排除静态资源
        addInterceptor.excludePathPatterns("/html/**");//排除静态资源
        addInterceptor.excludePathPatterns("/view/login");
        addInterceptor.excludePathPatterns("/login/check");
        addInterceptor.excludePathPatterns("/upload/**");
    }
	
}
