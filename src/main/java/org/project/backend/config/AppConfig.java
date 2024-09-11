package org.project.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.Entity;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.project.backend")  // backend 패키지 내 모든 컴포넌트 스캔
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");  // JSP 파일 경로
        resolver.setSuffix(".jsp");  // JSP 파일 확장자
        return resolver;
    }

    // 추가 설정 (MessageConverters, Interceptors 등 필요시 추가)
}
