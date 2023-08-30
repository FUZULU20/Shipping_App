package com.example.task2.controller;

import com.example.task2.dto.ProductsDto;
import com.example.task2.dto.request.ProductsRequest;
import com.example.task2.services.ProductsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductsController {

    final ProductsServices productsServices;

    @GetMapping(value = "/productsList")
    public List<ProductsDto> getProductInfo(){return productsServices.getAll();}

    @GetMapping(value = "/getProductsById/{id}")
    public ProductsDto getProductsById(@PathVariable(value = "id")Long id){
        return getProductsById(id);
    }

    @PostMapping(value = "/saveProducts")
    public void saveProducts(@RequestBody ProductsRequest productsRequest){
        productsServices.saveProducts(productsRequest);
    }

    @PostMapping(value = "/updateProducts")
    public void updateProducts (@RequestBody ProductsRequest productsRequest){
        productsServices.updateProducts(productsRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        productsServices.deleteById(id);
    }
}
