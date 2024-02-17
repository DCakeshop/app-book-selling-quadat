package com.example.appbookselling_quadat.mapper;

import com.example.appbookselling_quadat.beans.response.OrderResponse;
import com.example.appbookselling_quadat.entity.Order;

public class OrderMapper {
    public static OrderResponse convertToResponse(Order order){
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setCustomerId(order.getCustomerId());
        orderResponse.setBookId(order.getBookId());
        orderResponse.setOrderDate(order.getOrderDate());
        return orderResponse;
    }
}
