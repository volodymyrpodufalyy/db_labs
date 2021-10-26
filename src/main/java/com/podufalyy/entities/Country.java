package com.podufalyy.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Country {

    private String name;
    private String covidRules;

    public Country(String name, String covidRules) {
        this.name = name;
        this.covidRules = covidRules;
    }

    @Override
    public String toString() {
        return "\n\nCountry{" +
                "name='" + name + '\'' +
                ", covidRules='" + covidRules;
    }
}