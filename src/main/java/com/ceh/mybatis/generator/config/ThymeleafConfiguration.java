package com.ceh.mybatis.generator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * Created by enHui.Chen on 2018/9/17.
 */
@Configuration
public class ThymeleafConfiguration {

    @Bean
    public ClassLoaderTemplateResolver mybatisTemplateResolver() {
        ClassLoaderTemplateResolver emailTemplateResolver = new ClassLoaderTemplateResolver();
        emailTemplateResolver.setPrefix("/views/mybatis/");
        emailTemplateResolver.setSuffix(".html");
        emailTemplateResolver.setTemplateMode("HTML");
        emailTemplateResolver.setCharacterEncoding("UTF-8");
        emailTemplateResolver.setOrder(1);
        return emailTemplateResolver;
    }
}
