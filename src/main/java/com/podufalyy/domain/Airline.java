package com.podufalyy.domain;


import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "country_id")
    private Integer countryId;

    public Airline(String name, Integer country) {
        this.name = name;
        this.countryId = country;
    }

    @Override
    public String toString() {
        return "\n\nAirline  " +
                "name: " + name +
                "  , countryId=" + countryId;
    }
}
