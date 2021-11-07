package com.podufalyy.entities;
import com.podufalyy.enums.PlaneType;


import javax.persistence.*;
import java.util.Objects;


@Entity
public class Plane {
    private int id;
    private String name;
    private Integer seats;
    private PlaneType type;
    private Integer airlineId;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "seats")
    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    @Basic
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    public PlaneType getType() {
        return type;
    }

    public void setType(PlaneType type) {
        this.type = type;
    }

    @Basic
    @Column(name = "airline_id")
    public Integer getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Integer airlineId) {
        this.airlineId = airlineId;
    }

    public Plane() {
    }

    public Plane(String name, Integer seats, PlaneType type, Integer airlineId) {
        this.name = name;
        this.seats = seats;
        this.type = type;
        this.airlineId = airlineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        Plane plane = (Plane) o;
        return Objects.equals(getName(), plane.getName()) && Objects.equals(getSeats(), plane.getSeats()) && getType() == plane.getType() && Objects.equals(getAirlineId(), plane.getAirlineId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSeats(), getType(), getAirlineId());
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
