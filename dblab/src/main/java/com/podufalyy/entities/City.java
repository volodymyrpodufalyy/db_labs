package com.podufalyy.entities;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City {
    private String name;
    private Integer countryId;

    public City(String name, Integer countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "\n\nCity: name: " + name + ", countryId: " + countryId;
    }
}
