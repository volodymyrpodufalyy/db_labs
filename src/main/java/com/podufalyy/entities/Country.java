package com.podufalyy.entities;



import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Country {
    private int id;
    private String name;
    private String covidRules;

    public Country() {
    }

    @Id
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

    @Basic
    @Column(name = "covid_rules")
    public String getCovidRules() {
        return covidRules;
    }

    public void setCovidRules(String covidRules) {
        this.covidRules = covidRules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return getName().equals(country.getName()) && Objects.equals(getCovidRules(), country.getCovidRules());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCovidRules());
    }

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