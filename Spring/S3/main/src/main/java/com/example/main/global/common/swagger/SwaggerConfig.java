package com.example.main.global.common.swagger;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

@Configuration
public class SwaggerConfig {

        @Bean
        public OpenAPI openAPI() {
            return new OpenAPI()
                    .addSecurityItem(new SecurityRequirement().addList("JWT"))
                    .components(new Components().addSecuritySchemes("JWT", createAPIKeyScheme()))
                    .info(apiInfo());
        }

        @Bean
        public ModelResolver modelResolver(ObjectMapper objectMapper) {
            return new ModelResolver(objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE));
        }

        private SecurityScheme createAPIKeyScheme() {
            return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                    .bearerFormat("JWT")
                    .scheme("bearer");
        }

        private Info apiInfo() {
            return new Info()
                    .title("Spring Boot REST API Specifications")
                    .description("Specification")
                    .version("1.0.0");
        }

    @Bean
    public GroupedOpenApi getAuthApi() {
        return createGroupedOpenApi("blog", "/blog/**");
    }

    @Bean
    public GroupedOpenApi getFeedbackApi() {
        return createGroupedOpenApi("intern", "/intern/**");
    }


    private GroupedOpenApi createGroupedOpenApi(String groupName, String path) {
        return GroupedOpenApi.builder()
                .group(groupName)
                .pathsToMatch(path)
                .build();
    }



}