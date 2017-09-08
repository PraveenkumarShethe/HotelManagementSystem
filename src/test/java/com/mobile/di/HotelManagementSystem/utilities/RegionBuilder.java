package com.mobile.di.HotelManagementSystem.utilities;

import com.mobile.di.HotelManagementSystem.model.Region;

/**
 * Created by Praveenkumar on 9/8/2017.
 */
public class RegionBuilder {

    Region region;

    private RegionBuilder(){
        this.region = new Region();
    }

    public static RegionBuilder createRegion() {
        return new RegionBuilder();
    }

    public RegionBuilder setRegionName(String regionName){
        this.region.setRegionName(regionName);
        return this;
    }

    public Region getRegion(){
        return this.region;
    }
}
