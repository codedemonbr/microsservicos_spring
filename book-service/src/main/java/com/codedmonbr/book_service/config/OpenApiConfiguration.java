package com.codedmonbr.book_service.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
        info=@Info(
                title= "Book Microsservices API",
                version= "v1",
                description="Documentation of Book Microsservices API"
        )
)
public class OpenApiConfiguration {
    @Bean
    public OpenAPI cusOpenAPI(){
        return new OpenAPI()
                .components(new Components())
                .info(new io.swagger.v3.oas.models.info.Info()
                        .version("v1")
                        .title("Book Microservice API")
                        .license(
                                new License()
                                        .name("Apache 2.0")
                                        .url("https://mundoautomatico.app.br")
                        )
                );


    }
}
