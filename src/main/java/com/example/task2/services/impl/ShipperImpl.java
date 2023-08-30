package com.example.task2.services.impl;

import com.example.task2.dto.ShipperDto;
import com.example.task2.dto.request.ShipperRequest;
import com.example.task2.model.Shipper;
import com.example.task2.repository.ShipperRepository;
import com.example.task2.services.ShipperServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ShipperImpl implements ShipperServices {

    private final ShipperRepository shipperRepository;
    @Override
    public ShipperDto getShippersById(Long id) {
        Shipper shipper = shipperRepository.getShippersById(id);
        return ShipperDto.builder()
                .companyName(shipper.getCompanyName())
                .phone(shipper.getPhone())
                .build();
    }

    @Override
    public void saveShipper(ShipperRequest shipperRequest) {
        Shipper shipper = Shipper.builder()
                .companyName(shipperRequest.getCompanyName())
                .build();

        shipperRepository.save(shipper);
    }

    @Override
    public void updateShipper(ShipperRequest shipperRequest) {
        Shipper shipper = Shipper.builder()
                .companyName(shipperRequest.getCompanyName())
                .phone(shipperRequest.getPhone())
                .build();

        shipperRepository.save(shipper);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            throw new RuntimeException("There is no such information");
        } else {
            shipperRepository.deleteById(id);
        }
    }

    @Override
    public List<ShipperDto> getAll() {
        List<Shipper> shippers = shipperRepository.findAll();
        List<ShipperDto> shipperDtos = new ArrayList<>();

        for (Shipper shipper : shippers){
            ShipperDto shipperDto = ShipperDto.builder()
                    .companyName(shipper.getCompanyName())
                    .phone(shipper.getPhone())
                    .build();

            shipperDtos.add(shipperDto);
        }
        return shipperDtos;
    }
}
