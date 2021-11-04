package com.podufalyy.entities;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class City {
    private int id;
    private String name;
    private Integer countryId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return getName().equals(city.getName()) && getCountryId().equals(city.getCountryId());
    }

    public City() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCountryId());
    }

    @Basic
    @Column(name = "country_id")
    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public City(String name, Integer countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "\n\nCity: name: " + name + ", countryId: " + countryId;
    }
}
