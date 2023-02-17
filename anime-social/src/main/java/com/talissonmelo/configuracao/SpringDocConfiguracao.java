package com.talissonmelo.configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringDocConfiguracao {

    @Bean
    OpenAPI openAPI() {
        return new OpenAPI()
        		.info(new Info()
    				.title("Anime Social")
    				.version("v1")
    				.description("Usuários")
    				.license(new License().name("Apache 2.0").url("http://springdoc.com")))
    				.externalDocs(new ExternalDocumentation().description("Talisson Melo")
    						.url("https://github.com/TalissonMelo"));

    }
}
