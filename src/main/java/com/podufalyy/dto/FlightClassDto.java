package com.podufalyy.dto;


import com.podufalyy.enums.ClassType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightClassDto {
    private int id;
    private ClassType type;
    private String benefits;
    private Float price;
}
