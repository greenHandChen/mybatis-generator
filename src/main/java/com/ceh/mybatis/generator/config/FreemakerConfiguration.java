package com.ceh.mybatis.generator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

/**
 * Created by enHui.Chen on 2018/9/20.
 */
@Configuration
public class FreemakerConfiguration {

    @Bean(name = "cuxfreemakerConfiguration")
    public freemarker.template.Configuration freemakerConfiguration() throws IOException {
        freemarker.template.Configuration configuration = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_0);
        configuration.setDirectoryForTemplateLoading(new File(this.getClass().getResource("/").getPath()));
        configuration.setDefaultEncoding("UTF-8");
        return configuration;
    }
}
