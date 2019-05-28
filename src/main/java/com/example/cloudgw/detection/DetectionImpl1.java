package com.example.cloudgw.detection;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.Assert;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;

import java.net.URI;

/**
 * @author xiaotao
 * @version 1.0
 * @date: Created in 2019/5/28 20:49
 */
public class DetectionImpl1 implements Detection {
    @Override
    public void detect(final ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        URI uri = request.getURI();
        HttpHeaders headers = request.getHeaders();
        Flux<DataBuffer> body = request.getBody();

        //todo 对参数进行校验
        Assert.isTrue(uri.toString().contains("a"), "不行");
    }
}
