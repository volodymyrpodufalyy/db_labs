package com.podufalyy.domain;
import com.podufalyy.enums.PlaneType;
import lombok.*;


import javax.persistence.*;
import java.util.Objects;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "seats")
    private Integer seats;

    @Basic
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PlaneType type;

    @Basic
    @Column(name = "airline_id")
    private Integer airlineId;

    public Plane(String name, Integer seats, PlaneType type, Integer airlineId) {
        this.name = name;
        this.seats = seats;
        this.type = type;
        this.airlineId = airlineId;
    }

    @Override
    public String toString() {
        return "\n\nPlane{" +
                "name='" + name + '\'' +
                ", seats=" + seats +
                ", type='" + type + '\'' +
                ", airlineId=" + airlineId;
    }
}
