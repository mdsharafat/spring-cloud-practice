package com.microservice.apigateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/*****************************************
 * @author - Md. Sharafat Hossain
 * @email - mdsharafat047@gmail.com
 * @date - 04 Mar, 2024 at 2:41 PM
 ******************************************
 */

@Configuration
@Slf4j
public class CustomFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        log.info("Authorization : " + request.getHeaders().getFirst("Authorization"));
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            ServerHttpResponse response = exchange.getResponse();
            log.info("Response : " + response.getStatusCode());
        }));
    }
}
