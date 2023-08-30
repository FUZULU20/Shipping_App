package com.example.task2.services;

import com.example.task2.dto.ProductsDto;
import com.example.task2.dto.request.ProductsRequest;
import com.example.task2.model.Products;

import java.util.List;

public interface ProductsServices {

    ProductsDto getProductsById(Long id);

    void saveProducts(ProductsRequest productsRequest);

    void updateProducts(ProductsRequest productsRequest);

    void deleteById(Long id);

    List<ProductsDto> getAll();
}
