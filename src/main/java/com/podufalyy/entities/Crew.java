package com.podufalyy.entities;


import javax.persistence.*;


@Entity
public class Crew {
    private int id;
    private String mainPilot;
    private String stewardess;
    private String secondPilot;
    private Integer planeId;

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
    @Column(name = "main_pilot")
    public String getMainPilot() {
        return mainPilot;
    }

    public Crew() {
    }

    public void setMainPilot(String mainPilot) {
        this.mainPilot = mainPilot;
    }

    @Basic
    @Column(name = "stewardess")
    public String getStewardess() {
        return stewardess;
    }

    public void setStewardess(String stewardess) {
        this.stewardess = stewardess;
    }

    @Basic
    @Column(name = "second_pilot")
    public String getSecondPilot() {
        return secondPilot;
    }

    public void setSecondPilot(String secondPilot) {
        this.secondPilot = secondPilot;
    }

    @Basic
    @Column(name = "plane_id")
    public Integer getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Integer planeId) {
        this.planeId = planeId;
    }

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
