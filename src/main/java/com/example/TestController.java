package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "<h1>Hello, World</h1>";
    }

    @GetMapping("/thymeleaf/test")
    public String thymeleafTest() {
        return "test";
    }
}
