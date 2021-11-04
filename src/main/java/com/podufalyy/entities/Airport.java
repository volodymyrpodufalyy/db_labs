package com.podufalyy.entities;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Airport {
    private int id;
    private String name;
    private Integer countryId;
    private Integer cityId;



    public Airport(String name, Integer countryId, Integer cityId) {
        this.name = name;
        this.countryId = countryId;
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airport() {
    }

    @Basic
    @Column(name = "country_id")
    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "city_id")
    public Integer getCityId() {
        return cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;
        Airport airport = (Airport) o;
        return getName().equals(airport.getName()) && Objects.equals(getCountryId(), airport.getCountryId()) && Objects.equals(getCityId(), airport.getCityId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCountryId(), getCityId());
    }

    public void setCityId(Integer cityId) {
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
