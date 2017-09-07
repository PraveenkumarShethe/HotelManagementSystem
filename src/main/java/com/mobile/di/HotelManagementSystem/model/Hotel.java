package com.mobile.di.HotelManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Praveenkumar on 9/7/2017.
 * <p>
 * The hotel detail class
 */
@Entity
@Table(name = "HOTEL")
public class Hotel extends AbstractEntity {

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "hotel_address")
    private String hotelAddress;

    @Column(name = "hotel_ratings")
    private int hotelRatings;

    @ManyToOne(targetEntity = Region.class)
    @JoinColumn(name = "region_id")
    private Region region;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public int getHotelRatings() {
        return hotelRatings;
    }

    public void setHotelRatings(int hotelRatings) {
        this.hotelRatings = hotelRatings;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
