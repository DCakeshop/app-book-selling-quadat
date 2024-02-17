package com.example.appbookselling_quadat.repository;

import com.example.appbookselling_quadat.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findOrderById(int id);
    Order findOrderByOrderDate(Timestamp orderDate);
}
