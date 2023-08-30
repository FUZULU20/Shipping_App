package com.example.task2.services.impl;

import com.example.task2.dto.SuppliersDto;
import com.example.task2.dto.request.SuppliersRequest;
import com.example.task2.model.Suppliers;
import com.example.task2.repository.SuppliersRepository;
import com.example.task2.services.SuppliersServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class SuppliersImpl implements SuppliersServices {
    private final SuppliersRepository suppliersRepository;
    @Override
    public SuppliersDto getSuppliersById(Long id) {

        Suppliers suppliers = suppliersRepository.getSuppliersById(id);
        return SuppliersDto.builder()
                .companyName(suppliers.getCompanyName())
                .contactName(suppliers.getContactName())
                .address(suppliers.getAddress())
                .city(suppliers.getCity())
                .region(suppliers.getRegion())
                .country(suppliers.getCountry())
                .phone(suppliers.getPhone())
                .build();
    }

    @Override
    public void saveSuppliers(SuppliersRequest suppliersRequest) {

        Suppliers suppliers = Suppliers.builder()
                .companyName(suppliersRequest.getCompanyName())
                .address(suppliersRequest.getAddress())
                .country(suppliersRequest.getCountry())
                .phone(suppliersRequest.getPhone())
                .build();

        suppliersRepository.save(suppliers);

    }

    @Override
    public void updateSuppliers(SuppliersRequest suppliersRequest) {

        Suppliers suppliers = Suppliers.builder()
                .companyName(suppliersRequest.getCompanyName())
                .contactName(suppliersRequest.getContactName())
                .address(suppliersRequest.getAddress())
                .city(suppliersRequest.getCity())
                .country(suppliersRequest.getCountry())
                .phone(suppliersRequest.getPhone())
                .build();

        suppliersRepository.save(suppliers);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            throw new RuntimeException("There is no such information");
        } else {
            suppliersRepository.deleteById(id);
        }
    }

    @Override
    public List<SuppliersDto> getAll() {
        List<Suppliers> suppliers1 = suppliersRepository.findAll();
        List<SuppliersDto> suppliersDtos = new ArrayList<>();

        for (Suppliers suppliers : suppliers1){
            SuppliersDto suppliersDto = SuppliersDto.builder()
                    .companyName(suppliers.getCompanyName())
                    .contactName(suppliers.getContactName())
                    .address(suppliers.getAddress())
                    .city(suppliers.getCity())
                    .region(suppliers.getRegion())
                    .country(suppliers.getCountry())
                    .phone(suppliers.getPhone())
                    .build();

            suppliersDtos.add(suppliersDto);
        }
        return suppliersDtos;
    }
}
