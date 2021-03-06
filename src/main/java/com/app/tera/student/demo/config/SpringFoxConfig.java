package com.app.tera.student.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SpringFoxConfig {

    @Bean
    public Docket config(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metadata());
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("TERA QUIZ REST API documentation")
                .description("see https://github.com/singhneeraj282/Student-demo ")
                .version("1.0")
                .license("MIT Licence (MIT)")
                .licenseUrl("https://github.com/singhneeraj282/Student-demo ")
                .contact(contact())
                .build();
    }
    private Contact contact(){
        return new Contact("TERA QUIZ","https://github.com/singhneeraj282/Student-demo ", "singhneeraj.282@gmail.com");

    }

}
