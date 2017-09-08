package com.mobile.di.HotelManagementSystem.utilities;

import com.mobile.di.HotelManagementSystem.model.Hotel;
import com.mobile.di.HotelManagementSystem.model.Region;

/**
 * Created by Praveenkumar on 9/8/2017.
 */
public class HotelBuilder {

    Hotel hotel;

    public HotelBuilder(){
        this.hotel = new Hotel();
    }

    public static HotelBuilder createHotelBuilder() {
        return new HotelBuilder();
    }

    public HotelBuilder setHotelName(String hotelName) {
        this.hotel.setHotelName(hotelName);
        return this;
    }

    public HotelBuilder setRegion(Region region) {
        this.hotel.setRegion(region);
        return this;
    }

    public HotelBuilder setHotelAddress(String address) {
        this.hotel.setHotelAddress(address);
        return this;
    }

    public HotelBuilder setHotelRatings(int ratings) {
        this.hotel.setHotelRatings(ratings);
        return this;
    }

    public Hotel getHotel(){
        return this.hotel;
    }
}
