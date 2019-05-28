package com.example.cloudgw.config;

import com.example.cloudgw.filter.DetectionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author xiaotao
 * @version 1.0
 * @date: Created in 2019/5/28 20:46
 */
@Component
public class GatewayFilter implements GlobalFilter, Ordered {

    private List<DetectionFilter> detectionFilters;

    @Autowired
    public GatewayFilter(List<DetectionFilter> detectionFilters) {
        this.detectionFilters = detectionFilters;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        detectionFilters.parallelStream()
                .forEach(filter -> filter.handle(exchange));
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
