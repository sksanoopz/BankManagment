package com.dailycodechallenge.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder)
    {
        return builder.routes()
                .route(p->p.path("/bank-loan-plans/**")
                .uri("lb://bank-loan-plans"))
                .route(p->p.path("/bank-loan-enquiries/**")
                .uri("lb://bank-loan-enquiry"))
                .build();
    }
}
