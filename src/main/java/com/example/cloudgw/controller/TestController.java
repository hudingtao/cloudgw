package com.example.cloudgw.controller;


import com.example.cloudgw.model.Stu;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaotao
 * @version 1.0
 * @date: Created in 2019/5/28 17:34
 */
@RestController
public class TestController {

    @PostMapping("/test1")
    public Stu test1(@RequestBody Stu stu) {
        return stu;
    }
}
