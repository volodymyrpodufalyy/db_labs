package com.podufalyy.dto;


import com.podufalyy.enums.PlaneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaneDto {
    private int id;
    private String name;
    private Integer seats;
    private PlaneType type;
    private Integer airlineId;
}
