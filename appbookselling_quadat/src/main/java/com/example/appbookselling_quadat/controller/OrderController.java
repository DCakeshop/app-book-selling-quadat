package com.example.appbookselling_quadat.controller;

import com.example.appbookselling_quadat.beans.response.OrderResponse;
import com.example.appbookselling_quadat.entity.Order;
import com.example.appbookselling_quadat.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;

    @GetMapping("/all")
    public List<OrderResponse> getAllOrder(){
        return orderService.getOrderList();
    }

    @GetMapping("/{id}")
    public OrderResponse getDetailOrder(@PathVariable int id){
        return orderService.getDetailOrder(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody Order order){
        orderService.createOrder(order);
    }

    @PutMapping("/edit")
    public void update(@RequestBody Order order){
        orderService.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        orderService.delete(id);
    }
}
