package com.example.task2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsRequest {
    private Long id;
    private BigDecimal unitPrice;
    private int quantity;
    private BigDecimal discount;
}
