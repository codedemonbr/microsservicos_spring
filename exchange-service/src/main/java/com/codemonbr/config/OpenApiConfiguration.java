package com.codemonbr.config;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition(info = @Info(title = "Exchange Microsservices API", version = "v1", description = "Documentation of Exchange Microsservices API"))
public class OpenApiConfiguration {
        @Bean
        public OpenAPI cusOpenAPI() {
                return new OpenAPI()
                                .components(new Components())
                                .info(new io.swagger.v3.oas.models.info.Info()
                                                .version("v1")
                                                .title("Exchange Microservice API")
                                                .license(
                                                                new License()
                                                                                .name("Apache 2.0")
                                                                                .url("https://mundoautomatico.app.br")));

        }
}
