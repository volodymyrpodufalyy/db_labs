package com.podufalyy.domain;


import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "country_id")
    private Integer countryId;

    @Basic
    @Column(name = "city_id")
    private Integer cityId;

    public Airport(String name, Integer countryId, Integer cityId) {
        this.name = name;
        this.countryId = countryId;
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
