package com.example.cloudgw.detection;

import org.springframework.web.server.ServerWebExchange;

/**
 * @author xiaotao
 * @version 1.0
 * @date: Created in 2019/5/28 20:41
 */
public interface Detection {
    void detect(final ServerWebExchange exchange);
}
