package com.example.demowebsocket.controller;

import com.example.demowebsocket.repositories.OrderRepository;
import com.example.demowebsocket.entity.Order;
import com.example.demowebsocket.sevices.OrderService;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {

    private final OrderService orderService;
    private final SimpMessagingTemplate messagingTemplate;

    public OrderRestController(OrderService orderService, SimpMessagingTemplate messagingTemplate) {
        this.orderService = orderService;
        this.messagingTemplate = messagingTemplate;
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getAll();
    }

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        order.setProcessed(false);
        Order save = orderService.add(order);
        messagingTemplate.convertAndSend("/topic/orders", save);
        return save;
    }
}
