package com.example.task2.services;

import com.example.task2.dto.SuppliersDto;
import com.example.task2.dto.request.SuppliersRequest;

import java.util.List;

public interface SuppliersServices {
    SuppliersDto getSuppliersById(Long id);

    void saveSuppliers(SuppliersRequest suppliersRequest);

    void updateSuppliers(SuppliersRequest suppliersRequest);

    void deleteById(Long id);

    List<SuppliersDto> getAll();
}
