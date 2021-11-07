package com.podufalyy.domain;

import com.podufalyy.enums.ClassType;
import lombok.*;


import javax.persistence.*;
import java.util.Objects;

@Table(name = "class")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class FlightCLass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ClassType type;

    @Basic
    @Column(name = "benefits")
    private String benefits;

    @Basic
    @Column(name = "price")
    private Float price;

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
