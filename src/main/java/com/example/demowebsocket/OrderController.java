package com.example.demowebsocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    @GetMapping("/orders-page")
    public String showAllOrders(){
        return "test";
    }
}
