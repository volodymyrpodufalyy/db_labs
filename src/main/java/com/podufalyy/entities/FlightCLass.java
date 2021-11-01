package com.podufalyy.entities;

import com.podufalyy.enums.ClassType;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class FlightCLass {
    private int id;
    private ClassType type;
    private String benefits;
    private Float price;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type")
    public ClassType getType() {
        return type;
    }

    public void setType(ClassType type) {
        this.type = type;
    }

    @Basic
    @Column(name = "benefits")
    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    @Basic
    @Column(name = "price")
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public FlightCLass() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightCLass)) return false;
        FlightCLass that = (FlightCLass) o;
        return getType() == that.getType() && Objects.equals(getBenefits(), that.getBenefits()) && Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getBenefits(), getPrice());
    }

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
