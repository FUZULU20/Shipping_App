package com.example.task2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SuppliersDto {
    private String companyName;
    private String contactName;
    private String address;
    private String city;
    private String region;
    private String country;
    private String phone;
}
