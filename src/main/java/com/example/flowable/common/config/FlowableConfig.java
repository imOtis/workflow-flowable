package com.example.flowable.common.config;

import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.springframework.context.annotation.Configuration;

/**
 * @author: AAS
 * @create: 周三 11月 2019
 * @description: 解决流程图中文乱码
 */
@Configuration
public class FlowableConfig implements EngineConfigurationConfigurer<SpringProcessEngineConfiguration> {

    private static final String FontName = "宋体";

    @Override
    public void configure(SpringProcessEngineConfiguration engineConfiguration) {
        engineConfiguration.setActivityFontName(FontName);
        engineConfiguration.setLabelFontName(FontName);
        engineConfiguration.setAnnotationFontName(FontName);
    }
}
