package com.hoan.FoodOrdering.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:9999");
        server.setDescription("Development");

        Info info = new Info()
                .title("Restaurant Management System API")
                .version("1.0")
                .description("API Food Order");
        return new OpenAPI().info(info).servers(List.of(server));
    }

}
