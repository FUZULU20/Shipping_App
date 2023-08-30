package com.example.task2.services;

import com.example.task2.dto.ShipperDto;
import com.example.task2.dto.request.ShipperRequest;
import com.example.task2.model.Shipper;

import java.util.List;

public interface ShipperServices {

    ShipperDto getShippersById(Long id);

    void saveShipper(ShipperRequest shipperRequest);

    void updateShipper(ShipperRequest shipperRequest);

    void deleteById(Long id);

    List<ShipperDto> getAll();
}
