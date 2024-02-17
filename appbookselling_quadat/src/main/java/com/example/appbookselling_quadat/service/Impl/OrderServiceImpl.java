package com.example.appbookselling_quadat.service.Impl;

import com.example.appbookselling_quadat.beans.response.OrderResponse;
import com.example.appbookselling_quadat.entity.Order;
import com.example.appbookselling_quadat.exception.DuplicateException;
import com.example.appbookselling_quadat.exception.NotFoundException;
import com.example.appbookselling_quadat.mapper.OrderMapper;
import com.example.appbookselling_quadat.repository.OrderRepository;
import com.example.appbookselling_quadat.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    @Override
    public List<OrderResponse> getOrderList() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(OrderMapper::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse getDetailOrder(int id) throws NotFoundException {
        Order order = orderRepository.findOrderById(id);
        if (Objects.isNull(order)){
            throw new NotFoundException("Not Found Objects in Database");
        }
        return OrderMapper.convertToResponse(order);
    }

    @Override
    public void createOrder(Order obj) {
       Order order = orderRepository.findOrderByOrderDate(obj.getOrderDate());
       if (!Objects.isNull(order)){
           throw new DuplicateException("OrderDate exist in Database");
       }
       else {
           orderRepository.save(obj);
       }
    }

    @Override
    public void updateOrder(Order obj) {
        Order order = orderRepository.findOrderByOrderDate(obj.getOrderDate());
        if (!Objects.isNull(order)){
            throw new DuplicateException("OrderDate exist in Database");
        }
        else {
            orderRepository.save(obj);
        }
    }

    @Override
    public void delete(int id) {
        Order order = orderRepository.findOrderById(id);
        if (Objects.isNull(order)){
            throw new NotFoundException("Not Found Objects in Database");
        }
        else {
            orderRepository.delete(order);
        }
    }
}
