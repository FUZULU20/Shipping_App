package com.example.task2.services;

import com.example.task2.dto.OrderDetailsDto;
import com.example.task2.dto.request.OrderDetailsRequest;
import com.example.task2.model.OrderDetails;

import java.util.List;

public interface OrderDetailsServices {

    OrderDetailsDto getOrderDetailsById(Long id);

    void saveOrderDetails(OrderDetailsRequest orderDetailsRequest);

    void updateOrderDetails(OrderDetailsRequest orderDetailsRequest);

    void deleteById(Long id);

    List<OrderDetailsDto> getAll();
}
