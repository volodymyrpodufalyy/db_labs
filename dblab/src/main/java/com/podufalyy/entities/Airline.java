package com.podufalyy.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Airline {

    private String name;
    private Integer countryId;

    public Airline(String name, Integer countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "\n\nAirline  " +
                "name: " + name +
                "  , countryId=" + countryId;
    }
}
