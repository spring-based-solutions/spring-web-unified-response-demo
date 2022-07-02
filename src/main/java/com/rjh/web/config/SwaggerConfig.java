package com.rjh.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Swagger配置类
 * @author NULL
 * @since 2022-07-02
 */
//@ComponentScan(basePackages = {"com.rjh.web"})
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        Contact contact = new Contact("统一响应示例","https://github.com/spring-based-solutions/spring-web-unified-response-demo","jiehui.ruan@qq.com");
        ApiInfo apiInfo = new ApiInfo("统一响应示例","统一响应示例","1.0","",
                contact,"Apache 2.0","http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build();
    }

}
