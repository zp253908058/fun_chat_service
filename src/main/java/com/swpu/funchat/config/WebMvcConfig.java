package com.swpu.funchat.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;


/**
 * Description: funchat
 * Created by Zhu Peng on 2019/6/23
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private static Logger mLogger = LoggerFactory.getLogger(WebMvcConfig.class);

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        mLogger.info(FileStore.AVATAR_DIR);
        registry.addResourceHandler("/avatar/**").addResourceLocations("file:" + FileStore.AVATAR_DIR);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大KB,MB
        factory.setMaxFileSize(DataSize.ofMegabytes(10));
        //设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.ofMegabytes(20));
        return factory.createMultipartConfig();
    }
}
