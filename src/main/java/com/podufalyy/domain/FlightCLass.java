package com.podufalyy.domain;

import com.podufalyy.enums.ClassType;
import lombok.*;

import javax.persistence.*;

@Table(name = "class")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
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
