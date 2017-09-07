package com.mobile.di.HotelManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Praveenkumar on 9/7/2017.
 *
 * The hotel detail class
 */
@Entity
@Table(name = "HOTEL")
public class Hotel extends AbstractEntity{

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "hotel_address")
    private String hotelAddress;

    @Column(name = "hotel_ratings")
    private int hotelRatings;

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
}
