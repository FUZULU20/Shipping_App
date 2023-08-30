package com.example.task2.services;

import com.example.task2.dto.OrdersDto;
import com.example.task2.dto.request.OrdersRequest;
import com.example.task2.model.Orders;

import java.util.List;

public interface OrdersServices {
    OrdersDto getOrdersById(Long id);

    void saveOrders(OrdersRequest ordersRequest);

    void updateOrders(OrdersRequest ordersRequest);

    void deleteById(Long id);

    List<OrdersDto> getAll();
}
