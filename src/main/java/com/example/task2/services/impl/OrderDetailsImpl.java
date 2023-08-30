package com.example.task2.services.impl;

import com.example.task2.dto.OrderDetailsDto;
import com.example.task2.dto.request.OrderDetailsRequest;
import com.example.task2.model.OrderDetails;
import com.example.task2.repository.OrderDetailsRepository;
import com.example.task2.services.OrderDetailsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailsImpl implements OrderDetailsServices {

    private final OrderDetailsRepository orderDetailsRepository;
    @Override
    public OrderDetailsDto getOrderDetailsById(Long id) {
        OrderDetails orderDetails = orderDetailsRepository.getOrderDetailsById(id);
        return OrderDetailsDto.builder()
                .discount(orderDetails.getDiscount())
                .quantity(orderDetails.getQuantity())
                .unitPrice(orderDetails.getUnitPrice())
                .build();
    }

    @Override
    public void saveOrderDetails(OrderDetailsRequest orderDetailsRequest) {
        OrderDetails orderDetails = OrderDetails.builder()
                .unitPrice(orderDetailsRequest.getUnitPrice())
                .quantity(orderDetailsRequest.getQuantity())
                .build();

        orderDetailsRepository.save(orderDetails);
    }

    @Override
    public void updateOrderDetails(OrderDetailsRequest orderDetailsRequest) {
        OrderDetails orderDetails = OrderDetails.builder()
                .unitPrice(orderDetailsRequest.getUnitPrice())
                .quantity(orderDetailsRequest.getQuantity())
                .discount(orderDetailsRequest.getDiscount())
                .build();

        orderDetailsRepository.save(orderDetails);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            throw new RuntimeException("There is no such information");
        } else {
            orderDetailsRepository.deleteById(id);
        }
    }

    @Override
    public List<OrderDetailsDto> getAll() {
        List<OrderDetails> orderDetails1 = orderDetailsRepository.findAll();
        List<OrderDetailsDto> orderDetailsDtos = new ArrayList<>();

        for (OrderDetails orderDetails : orderDetails1){
            OrderDetailsDto orderDetailsDto = OrderDetailsDto.builder()
                    .unitPrice(orderDetails.getUnitPrice())
                    .discount(orderDetails.getDiscount())
                    .quantity(orderDetails.getQuantity())
                    .build();

            orderDetailsDtos.add(orderDetailsDto);
        }
        return orderDetailsDtos;
    }
}
