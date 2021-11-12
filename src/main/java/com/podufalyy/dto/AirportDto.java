package com.podufalyy.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirportDto {
    private Integer id;
    private String name;
    private Integer countryId;
    private Integer cityId;
}
