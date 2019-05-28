package com.example.cloudgw.filter;

import com.example.cloudgw.detection.Detection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;

/**
 * @author xiaotao
 * @version 1.0
 * @date: Created in 2019/5/28 20:39
 */
@Service
public class DetectionFilterImpl implements DetectionFilter{

    private List<Detection> detections;

    @Autowired
    public DetectionFilterImpl(final List<Detection> detections) {
        this.detections = detections;
    }

    @Override
    public void handle(final ServerWebExchange exchange) {
        detections.parallelStream()
                .forEach(filter -> filter.detect(exchange));
    }
}
