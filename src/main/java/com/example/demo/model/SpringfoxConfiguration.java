package com.example.demo.model;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringfoxConfiguration {

    @Bean
    public Docket docket() {
    	return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .paths(PathSelectors.regex("/.*")).build();
    	
//    	return new Docket(DocumentationType.SWAGGER_2)
//    		      .tags(new Tag("Employee Entity", "Repository for Employee entities"));
    
//    	return new Docket(DocumentationType.SWAGGER_2)
//    	        .apiInfo(apiInfo()).select()
//    	        .apis(RequestHandlerSelectors.any())
//    	        .paths(..))
//    	        .build()
//    	        .tags(new Tag("Channel Entity", "Data-rest endpoints"));
    
    
    
    }

}
