package com.codeguru.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Autowired
    BuildProperties buildProperties;

    public static final String API_TAG = "Service";

    @Bean
    public Docket apiDocumentation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any()).paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .tags(new Tag(API_TAG, buildProperties.getName() + " API documentation."));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(buildProperties.getArtifact() + " API")
                .description("API Documentation and a guid to getting started")
                .termsOfServiceUrl("https://galaxygroup.biz/#about")
                .contact(new Contact("Code GURU", "https://codeguru-pro.com/", "info@codeguru-pro.com"))
                .version(buildProperties.getVersion()).build();
    }
}
