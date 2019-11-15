package com.example.flowable.common.config;

import io.swagger.annotations.ApiOperation;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.FileReader;
import java.io.IOException;

/**
 * Create Time: 2019/10/1 12:22
 * Description: Swagger可视化API配置
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() throws IOException, XmlPullParserException {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //以下扫描方式选择一种即可
                //采用包含注解的方式来确定要显示的接口
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //采用包扫描的方式来确定要显示的接口
                //.apis(RequestHandlerSelectors.basePackage("cn.stylefeng.guns.modular.system.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() throws IOException, XmlPullParserException {
        MavenXpp3Reader mavenXpp3Reader = new MavenXpp3Reader();
        Model model = mavenXpp3Reader.read(new FileReader("pom.xml"));
        return new ApiInfoBuilder()
                // 页面标题
                .title("Flowable Workflow")
                // 描述
                .description("API Document For Flowable Workflow")
                // 服务条款网址
                //.termsOfServiceUrl("https://baidu.com")
                // 创建人
                .contact(new Contact("ShawSail",
                        "https://gogs.analyticservice.net/shawsail.xiao/flowable",
                        "ShawSail.Xaio@analyticservice.net"))
                // 版本号
                .version(model.getVersion())
                .build();
    }

}