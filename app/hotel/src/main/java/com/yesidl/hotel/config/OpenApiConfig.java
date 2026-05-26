package com.yesidl.hotel.config;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
        title = "Hotel API",
        version = "1.0.0",
        description = "API para gestionar hoteles, huespedes y reservas"
    ),
    servers = {
        @io.swagger.v3.oas.annotations.servers.Server(url = "http://localhost:8080", description = "Servidor local")
    }
    
)

@Configuration
public class OpenApiConfig {

}
