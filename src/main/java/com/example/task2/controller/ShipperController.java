package com.example.task2.controller;

import com.example.task2.dto.ShipperDto;
import com.example.task2.dto.request.ShipperRequest;
import com.example.task2.services.ShipperServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/shipper")
public class ShipperController {
    final ShipperServices shipperServices;

    @GetMapping(value = "/shipperList")
    public List<ShipperDto> getShipperInfo() {return shipperServices.getAll();}

    @GetMapping(value = "/getShippersById/{id}")
    public ShipperDto getShippersById(@PathVariable(value = "id") Long id){
        return getShippersById(id);
    }

    @PostMapping(value = "/saveShipper")
    public void saveShipper(@RequestBody ShipperRequest shipperRequest){
       shipperServices.saveShipper(shipperRequest);
    }

    @PostMapping(value = "/updateShipper")
    public void updateShipper(@RequestBody ShipperRequest shipperRequest){
        shipperServices.updateShipper(shipperRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        shipperServices.deleteById(id);
    }
}
