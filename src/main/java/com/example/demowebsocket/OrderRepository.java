package com.example.demowebsocket;

import com.example.demowebsocket.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByProcessed(boolean processed);
}
