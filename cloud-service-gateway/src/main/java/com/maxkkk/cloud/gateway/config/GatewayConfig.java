package com.maxkkk.cloud.gateway.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class GatewayConfig {

/*	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/payment/**").uri("lb://CLOUD-PROVIDER-PAYMENT"))
				.build();
	}*/
}
