package com.example.demowebsocket.sevices;

import com.example.demowebsocket.entity.Order;
import com.example.demowebsocket.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order add(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(long id) {
        return orderRepository.findById(id).orElseThrow();
    }

    @Override
    public Order update(Order order) {
        return add(order);
    }

    @Override
    public boolean delete(long id) {
        try {
            orderRepository.delete(getById(id));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
