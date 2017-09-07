package com.mobile.di.HotelManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by Praveenkumar on 9/7/2017.
 */
@Entity
@Table(name = "REGION")
public class Region extends AbstractEntity {

    @Column(name = "region_name")
    private String regionName;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
