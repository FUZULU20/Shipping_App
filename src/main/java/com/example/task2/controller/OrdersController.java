package com.example.task2.controller;

import com.example.task2.dto.OrdersDto;
import com.example.task2.dto.request.OrdersRequest;
import com.example.task2.services.OrdersServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/orders")
public class OrdersController {

    final OrdersServices ordersServices;

    @GetMapping(value = "/ordersList")
    public List<OrdersDto> getOrdersInfo(){return ordersServices.getAll();}

    @GetMapping(value = "/getOrdersById/{id}")
    public OrdersDto getOrdersById(@PathVariable(value = "id") Long id){
        return getOrdersById(id);
    }

    @PostMapping(value = "/saveOrders")
    public void saveOrders(@RequestBody OrdersRequest ordersRequest){
        ordersServices.saveOrders(ordersRequest);
    }

    @PostMapping(value = "/updateOrders")
    public void updateOrders(@RequestBody OrdersRequest ordersRequest){
        ordersServices.updateOrders(ordersRequest);
    }


    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        ordersServices.deleteById(id);
    }
}
