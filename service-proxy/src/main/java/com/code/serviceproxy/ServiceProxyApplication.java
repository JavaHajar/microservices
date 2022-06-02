package com.code.serviceproxy;

import io.netty.resolver.DefaultAddressResolverGroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import reactor.netty.http.client.HttpClient;


@SpringBootApplication
@EnableEurekaClient
public class ServiceProxyApplication {

	@Bean
	RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route( r ->r.path("/categories/**").filters(f -> f.stripPrefix(1))
						.uri("http://localhost:8082"))
				.route( r ->r.path("/products/**").filters(f -> f.stripPrefix(1))
						.uri("http://localhost:8084"))
				.build();
	}
	@Bean
	public HttpClient httpClient() {
		return HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
	}
	public static void main(String[] args) {
		SpringApplication.run(ServiceProxyApplication.class, args);
	}

}
