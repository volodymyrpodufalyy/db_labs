package com.podufalyy.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Crew {
    private String mainPilot;
    private String stewardess;
    private String secondPilot;
    private Integer planeId;

    public Crew(String mainPilot, String stewardess, String secondPilot, Integer planeId) {
        this.mainPilot = mainPilot;
        this.stewardess = stewardess;
        this.secondPilot = secondPilot;
        this.planeId = planeId;
    }

    @Override
    public String toString() {
        return "\n\nCrew{" +
                "mainPilot='" + mainPilot + '\'' +
                ", stewardess='" + stewardess + '\'' +
                ", secondPilot='" + secondPilot + '\'' +
                ", planeId=" + planeId;
    }
}
