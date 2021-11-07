package com.podufalyy.domain;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "country")
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "covid_rules")
    private String covidRules;

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