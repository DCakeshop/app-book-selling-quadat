package com.example.appbookselling_quadat.service;

import com.example.appbookselling_quadat.beans.response.OrderResponse;
import com.example.appbookselling_quadat.entity.Order;
import com.example.appbookselling_quadat.exception.NotFoundException;

import java.util.List;

public interface OrderService {
    List<OrderResponse> getOrderList();
    OrderResponse getDetailOrder(int id) throws NotFoundException;
    void createOrder(Order obj);
    void updateOrder(Order obj);
    void delete(int id);
}
