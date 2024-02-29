package com.coder.ecommerce.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSwagger {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Ecommerce APIRest")
                        .description("APIRest ventas Ecommerce")
                        .contact(new Contact()
                                .name("Demian Zuk")
                                .email("demianzuk32@gmail.com")
                                .url("https://github.com/demianzuk32"))
                        .version("1.0"));
    }
}