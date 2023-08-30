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
public class OrdersDto {
    private Date orderDate;
    private Date shippedDate;
    private String freight;
    private String shipName;
    private String shipAddress;
}
