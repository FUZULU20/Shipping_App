package com.example.task2.controller;

import com.example.task2.dto.OrderDetailsDto;
import com.example.task2.dto.request.OrderDetailsRequest;
import com.example.task2.services.OrderDetailsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/order_details")
public class OrderDetailsController {

    final OrderDetailsServices orderDetailsServices;

    @GetMapping(value = "/order_details_List")
    public List<OrderDetailsDto> getOrderDetailsInfo(){return orderDetailsServices.getAll();}

    @GetMapping(value = "/getOrderDetailsById/{id}")
    public OrderDetailsDto getOrderDetailsById(@PathVariable(value = "id") Long id){
        return getOrderDetailsById(id);
    }

    @PostMapping(value = "/saveOrderDetails")
    public void saveOrderDetails(@RequestBody OrderDetailsRequest orderDetailsRequest){
        orderDetailsServices.saveOrderDetails(orderDetailsRequest);
    }

    @PostMapping(value = "/updateOrderDetails")
    public void updateOrderDetails(@RequestBody OrderDetailsRequest orderDetailsRequest){
        orderDetailsServices.updateOrderDetails(orderDetailsRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        orderDetailsServices.deleteById(id);
    }

}
