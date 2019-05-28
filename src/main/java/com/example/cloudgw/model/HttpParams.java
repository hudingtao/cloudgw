package com.example.cloudgw.model;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author xiaotao
 * @version 1.0
 * @date: Created in 2019/5/28 20:54
 */
public class HttpParams {
    private ServerHttpRequest request;
    private ServerHttpResponse response;

    public HttpParams(ServerWebExchange exchange) {
        this.request = exchange.getRequest();
        this.response = exchange.getResponse();
    }

    public URI getUri() {
        return request.getURI();
    }

    public HttpHeaders getRequestHeaders() {
        return response.getHeaders();
    }

    public String getRequestBodyStr() {
        Flux<DataBuffer> body = request.getBody();

        AtomicReference<String> bodyref = new AtomicReference<>();

        body.subscribe(buffer -> {
            final CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer.asByteBuffer());
            DataBufferUtils.release(buffer);
            bodyref.set(charBuffer.toString());
        });

        return bodyref.get();
    }

}
