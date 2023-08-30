package com.example.task2.services.impl;

import com.example.task2.dto.ProductsDto;
import com.example.task2.dto.request.ProductsRequest;
import com.example.task2.model.Products;
import com.example.task2.repository.ProductsRepository;
import com.example.task2.services.ProductsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductsImpl implements ProductsServices {
    private final ProductsRepository productsRepository;
    @Override
    public ProductsDto getProductsById(Long id) {
        Products products = productsRepository.getProductsById(id);
        return ProductsDto.builder()
                .productName(products.getProductName())
                .discontinued(products.getDiscontinued())
                .quantityPerUnit(products.getQuantityPerUnit())
                .unitPrice(products.getUnitPrice())
                .unitsInStock(products.getUnitsInStock())
                .build();
    }

    @Override
    public void saveProducts(ProductsRequest productsRequest) {
            Products products = Products.builder()
                    .productName(productsRequest.getProductName())
                    .quantityPerUnit(productsRequest.getQuantityPerUnit())
                    .unitPrice(productsRequest.getUnitPrice())
                    .build();

            productsRepository.save(products);
    }

    @Override
    public void updateProducts(ProductsRequest productsRequest) {
        Products products = Products.builder()
                .productName(productsRequest.getProductName())
                .quantityPerUnit(productsRequest.getQuantityPerUnit())
                .unitPrice(productsRequest.getUnitPrice())
                .unitsInStock(productsRequest.getUnitsInStock())
                .build();

        productsRepository.save(products);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            throw new RuntimeException("There is no such information");
        } else {
            productsRepository.deleteById(id);
        }
    }

    @Override
    public List<ProductsDto> getAll() {
        List<Products> products1 = productsRepository.findAll();
        List<ProductsDto> productsDtos = new ArrayList<>();

        for (Products products : products1){
            ProductsDto productsDto = ProductsDto.builder()
                    .productName(products.getProductName())
                    .discontinued(products.getDiscontinued())
                    .quantityPerUnit(products.getQuantityPerUnit())
                    .unitPrice(products.getUnitPrice())
                    .unitsInStock(products.getUnitsInStock())
                    .build();

            productsDtos.add(productsDto);
        }
        return productsDtos;
    }
}
