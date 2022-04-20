package com.symbiosis.app.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig implements OpenApiCustomiser {

    @Override
    public void customise(OpenAPI openApi) {
        openApi.getInfo().setTitle("Symbiosis API");
        openApi.getInfo().setVersion("1.0");
    }
}
