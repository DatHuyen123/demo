package com.dangvandat.entity;

import com.dangvandat.builder.BuildingSearchBuilder;

import javax.persistence.*;

@Entity
//@Embeddable
@Table(name = "rentarea")
public class RentArea extends BaseEntity{

    @Column(name = "value")
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buildingid")
    private BuildingEntity building;

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public BuildingEntity getBuilding() {
        return building;
    }
    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }
}
