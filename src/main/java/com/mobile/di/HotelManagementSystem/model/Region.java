package com.mobile.di.HotelManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Praveenkumar on 9/7/2017.
 */
@Entity
@Table(name = "REGION")
public class Region extends AbstractEntity implements Serializable {

    @Column(name = "region_name")
    private String regionName;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Region region = (Region) o;

        return regionName != null ? regionName.equals(region.regionName) : region.regionName == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        return result;
    }
}
