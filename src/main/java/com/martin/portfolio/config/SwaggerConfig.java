package com.martin.portfolio.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Value("${jwt.scheme.name}")
    private String jwtSchemeName;

    @Value("${jwt.scheme.type}")
    private String jwtSchemeType;

    @Value("${jwt.scheme.format}")
    private String jwtSchemeFormat;

    @Value("${jwt.header}")
    private String jwtHeader;

    @Bean
    public OpenAPI openAPI() {

        return new OpenAPI()
                //.servers(List.of(new Server().url("/").description("Default server url")))
                .components(new Components()
                        .addSecuritySchemes(jwtSchemeName,
                                new SecurityScheme()
                                        .name(jwtSchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme(jwtSchemeType)
                                        .bearerFormat(jwtSchemeFormat)
                                        .in(SecurityScheme.In.HEADER).name(jwtHeader)
                        )

                )
                .info(new Info()
                        .title("Portfolio API")
                        .version("0.0.6")
                        .description("Martin Antolini")
                );
    }
}
