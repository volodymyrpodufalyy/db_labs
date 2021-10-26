package com.podufalyy.entities;
import com.podufalyy.enums.PlaneType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Plane {
    private String name;
    private Integer seats;
    private PlaneType type;
    private Integer airlineId;

    public Plane(String name, Integer seats, PlaneType type, Integer airlineId) {
        this.name = name;
        this.seats = seats;
        this.type = type;
        this.airlineId = airlineId;
    }

    @Override
    public String toString() {
        return "\n\nPlane{" +
                "name='" + name + '\'' +
                ", seats=" + seats +
                ", type='" + type + '\'' +
                ", airlineId=" + airlineId;
    }
}
