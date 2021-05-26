package com.cloudtest.gateway2.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
         return routes.route("payment_routh",r->r.path("/payment/get/**").uri("http://localhost:8001"))
                .route("payment_routh2",r->r.path("/payment/payment/discovery").uri("http://localhost:8001"))
                .build();
    }
}
