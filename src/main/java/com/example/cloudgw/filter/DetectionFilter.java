package com.example.cloudgw.filter;

import org.springframework.web.server.ServerWebExchange;

/**
 * @author xiaotao
 * @version 1.0
 * @date: Created in 2019/5/28 20:45
 */
public interface DetectionFilter {
    void handle(ServerWebExchange exchange);
}
