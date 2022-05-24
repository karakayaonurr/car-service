package com.karakaya.car.service.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by TCOKARAKAYA on 24.05.2022.
 */
@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public OpenAPI creditOpenAPI() {
        return new OpenAPI().info(new Info().title("CarService Application API").description("CarService Project")
                        .version("v0.0.1").license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation().description("Onur Karakaya")
                        .url("https://github.com/karakayaonurr"));
    }
}
