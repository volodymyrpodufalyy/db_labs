package com.podufalyy.entities;


import javax.persistence.*;
import java.util.Objects;


@Entity
public class Airline {

    private Integer id;
    private String name;
    private Integer countryId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Basic
    @Column(name = "country_id")
    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airline)) return false;
        Airline airline = (Airline) o;
        return getId().equals(airline.getId()) && getName().equals(airline.getName()) && getCountryId().equals(airline.getCountryId());
    }

    public Airline() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCountryId());
    }

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
