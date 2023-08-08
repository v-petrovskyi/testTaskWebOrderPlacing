package com.example.demowebsocket.sevices;

import com.example.demowebsocket.entity.Order;

import java.util.List;

public interface OrderService {
    Order add(Order order);
    List<Order> getAll();
    Order getById(long id);
    Order update(Order order);
    boolean delete(long id);
}
