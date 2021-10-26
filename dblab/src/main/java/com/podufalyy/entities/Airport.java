package com.podufalyy.entities;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Airport {
    private String name;
    private Integer countryId;
    private Integer cityId;

    public Airport(String name, Integer countryId, Integer cityId) {
        this.name = name;
        this.countryId = countryId;
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "\n\nAirport{" +
                "name='" + name + '\'' +
                ", countryId=" + countryId +
                ", cityId=" + cityId;
    }
}
