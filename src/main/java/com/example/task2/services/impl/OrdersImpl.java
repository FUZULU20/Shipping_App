package com.example.task2.services.impl;

import com.example.task2.dto.OrdersDto;
import com.example.task2.dto.request.OrdersRequest;
import com.example.task2.model.Orders;
import com.example.task2.repository.OrdersRepository;
import com.example.task2.services.OrdersServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersImpl implements OrdersServices {

    private final OrdersRepository ordersRepository;
    @Override
    public OrdersDto getOrdersById(Long id) {
        Orders orders = ordersRepository.getOrdersById(id);
        return OrdersDto.builder()
                .orderDate(orders.getOrderDate())
                .shippedDate(orders.getShippedDate())
                .freight(orders.getFreight())
                .shipAddress(orders.getShipAddress())
                .shipName(orders.getShipName())
                .build();
    }

    @Override
    public void saveOrders(OrdersRequest ordersRequest) {
        Orders orders = Orders.builder()
                .orderDate(ordersRequest.getOrderDate())
                .shippedDate(ordersRequest.getShippedDate())
                .freight(ordersRequest.getFreight())
                .build();

        ordersRepository.save(orders);
    }

    @Override
    public void updateOrders(OrdersRequest ordersRequest) {
        Orders orders = Orders.builder()
                .orderDate(ordersRequest.getOrderDate())
                .shippedDate(ordersRequest.getShippedDate())
                .freight(ordersRequest.getFreight())
                .shipName(ordersRequest.getShipName())
                .build();

        ordersRepository.save(orders);
    }

    @Override
    public void deleteById(Long id) {

        if (id == null) {
            throw new RuntimeException("There is no such information");
        } else {
            ordersRepository.deleteById(id);
        }
    }

    @Override
    public List<OrdersDto> getAll() {
        List<Orders> orders1 = ordersRepository.findAll();
        List<OrdersDto> ordersDtos = new ArrayList<>();

        for (Orders orders : orders1){
            OrdersDto ordersDto = OrdersDto.builder()
                    .orderDate(orders.getOrderDate())
                    .shippedDate(orders.getShippedDate())
                    .freight(orders.getFreight())
                    .shipName(orders.getShipName())
                    .shipAddress(orders.getShipAddress())
                    .build();

            ordersDtos.add(ordersDto);
        }

        return ordersDtos;
    }
}
