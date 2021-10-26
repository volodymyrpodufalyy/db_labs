package com.podufalyy.entities;

import com.podufalyy.enums.ClassType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightCLass {
    private ClassType type;
    private String benefits;
    private Float price;

    public FlightCLass(ClassType type, String benefits, Float price) {
        this.type = type;
        this.benefits = benefits;
        this.price = price;
    }

    @Override
    public String toString() {
        return "\n\nFlightCLass{" +
                "type=" + type +
                ", benefits='" + benefits + '\'' +
                ", price=" + price;
    }
}
