package com.TRA.tra24Springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("A")
    public String hello(){
        return "Abdullah";
    }
}
