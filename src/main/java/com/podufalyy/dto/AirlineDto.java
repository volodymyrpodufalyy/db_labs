package com.podufalyy.dto;


import com.podufalyy.domain.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirlineDto {
    private Integer id;
    private String name;
    private Integer countryId;
}
