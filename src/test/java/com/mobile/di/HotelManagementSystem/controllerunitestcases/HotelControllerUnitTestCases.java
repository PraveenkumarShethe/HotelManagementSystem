package com.mobile.di.HotelManagementSystem.controllerunitestcases;

import com.mobile.di.HotelManagementSystem.controller.HotelsController;
import com.mobile.di.HotelManagementSystem.model.Hotel;
import com.mobile.di.HotelManagementSystem.model.Region;
import com.mobile.di.HotelManagementSystem.utilities.HotelBuilder;
import com.mobile.di.HotelManagementSystem.utilities.RegionBuilder;
import com.mobile.di.HotelManagementSystem.validator.HotelValidator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by Praveenkumar on 9/8/2017.
 */
public class HotelControllerUnitTestCases {

    @InjectMocks
    private HotelsController hotelsController;

    @Mock
    private HotelValidator hotelValidator;

    @Test
    private void getAllHoetlMustPass(){

        Region region = RegionBuilder
                .createRegion()
                .setRegionName("NORTH_INDIAN")
                .getRegion();

        Hotel hotel = HotelBuilder
                .createHotelBuilder()
                .setHotelName("Lila Palace")
                .setHotelAddress("BTM 1st Stage Bangalore")
                .setHotelRatings(5)
                .getHotel();
    }

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
}
