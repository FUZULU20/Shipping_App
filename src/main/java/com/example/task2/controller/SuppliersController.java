package com.example.task2.controller;

import com.example.task2.dto.SuppliersDto;
import com.example.task2.dto.request.SuppliersRequest;
import com.example.task2.services.SuppliersServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/suppliers")
public class SuppliersController {

    final SuppliersServices suppliersServices;

    @GetMapping(value = "/suppliersList")
    public List<SuppliersDto> getSuppliersInfo(){return suppliersServices.getAll();}

    @GetMapping(value = "/getSuppliersById/{id}")
    public SuppliersDto getSuppliersById(@PathVariable(value = "id")Long id){return getSuppliersById(id);}

    @PostMapping(value = "/saveSuppliers")
    public void saveSuppliers(@RequestBody SuppliersRequest suppliersRequest){
        suppliersServices.saveSuppliers(suppliersRequest);
    }

    @PostMapping(value = "/updateSuppliers")
    public void updateSuppliers(@RequestBody SuppliersRequest suppliersRequest){
        suppliersServices.updateSuppliers(suppliersRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        suppliersServices.deleteById(id);
    }

}

