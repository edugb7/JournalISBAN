package com.isb.conciliator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket conciliatorApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(conciliatorApiInfo())
                .select()
                .paths(PathSelectors.ant("/movements_conciliator/*/**"))
                .apis(RequestHandlerSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo conciliatorApiInfo() {
        return new ApiInfoBuilder()
                .title("Service Movements Conciliator")
                .version("1.0")
                .license("Apache License Version 2.0")
                .build();
    }

}
