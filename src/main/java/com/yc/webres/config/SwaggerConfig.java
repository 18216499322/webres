package com.yc.webres.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.yc.webres.vo.JsonModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * program:webres
 * description:swaggerconfig
 * author:lsj
 * create:2021-05-05 08:50
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .ignoredParameterTypes(JsonModel.class, HttpSession.class, HttpServletRequest.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yc"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("小萌神网络订餐系统接口文档")
                .description("接口文档包括用户、菜品、订单等接口")
                .termsOfServiceUrl("http://localhost/res/")
                .contact("718261933@qq.com")
                .version("1.0")
                .build();
    }
}
