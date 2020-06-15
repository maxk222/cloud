package com.maxkkk.cloud.gateway.filter;

import java.util.Date;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@SpringBootConfiguration
public class MyLogFilter implements GlobalFilter, Ordered {

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("****** come in MyLogGateWayFilter: " + new Date());

		String uname = exchange.getRequest().getQueryParams().getFirst("uname");
		if (uname == null) {
			log.info("*****用户名为null，非法用户，o(╥﹏╥)o");
			exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
			return exchange.getResponse().setComplete();
		}
		return chain.filter(exchange);
	}

}
