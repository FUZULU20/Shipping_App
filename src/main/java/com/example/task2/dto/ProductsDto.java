package com.example.task2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDto {
    private String productName;
    private String quantityPerUnit;
    private String unitPrice;
    private String unitsInStock;
    private Date discontinued;
}
