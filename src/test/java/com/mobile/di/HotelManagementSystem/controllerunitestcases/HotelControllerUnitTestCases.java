package com.mobile.di.HotelManagementSystem.controllerunitestcases;

import com.mobile.di.HotelManagementSystem.controller.HotelsController;
import com.mobile.di.HotelManagementSystem.controller.RestPreconditions;
import com.mobile.di.HotelManagementSystem.controller.restexceptionhandler.HMSResourceNotFoundException;
import com.mobile.di.HotelManagementSystem.model.Hotel;
import com.mobile.di.HotelManagementSystem.model.Region;
import com.mobile.di.HotelManagementSystem.repository.HotelRepository;
import com.mobile.di.HotelManagementSystem.repository.RegionRepository;
import com.mobile.di.HotelManagementSystem.utilities.HotelBuilder;
import com.mobile.di.HotelManagementSystem.utilities.RegionBuilder;
import com.mobile.di.HotelManagementSystem.validator.HotelValidator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Praveenkumar on 9/8/2017.
 */
public class HotelControllerUnitTestCases {

    @InjectMocks
    private HotelsController hotelsController;

    @Mock
    private HotelValidator hotelValidator;
    @Mock
    private HotelRepository hotelRepository;
    @Mock
    private RegionRepository regionRepository;

    @Test
    public void getAllHoetlMustPass() {

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

        Hotel hotel1 = HotelBuilder
                .createHotelBuilder()
                .setHotelName("Lila Palace")
                .setHotelAddress("BTM 1st Stage Bangalore")
                .setHotelRatings(5)
                .getHotel();

        ArrayList listOfHotels = new ArrayList();
        when(hotelsController.getAllHotels()).thenReturn((Iterable<Hotel>) listOfHotels);
        Iterable<Hotel> hotels = hotelsController.getAllHotels();
        verify(hotelRepository, times(1)).findAll();
    }

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getHotelByIdMustPass() throws HMSResourceNotFoundException {

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
        when(hotelRepository.findOne(1L)).thenReturn(hotel);
        when(hotelsController.getHotelById(1L)).thenReturn(hotel);
        when(RestPreconditions.checkFound(hotelRepository.findOne(1L))).thenReturn(hotel);
        Hotel hotels = hotelsController.getHotelById(1L);
        assertNotNull(hotel);
        verify(hotelRepository, times(1)).findOne(1L);
    }

    @Test
    public void getHotelByRegionPass() throws HMSResourceNotFoundException {

        Region region = RegionBuilder
                .createRegion()
                .setRegionName("NORTH_INDIAN")
                .getRegion();

        Region region1 = RegionBuilder
                .createRegion()
                .setRegionName("SOUTH_INDIAN")
                .getRegion();

        Hotel hotel = HotelBuilder
                .createHotelBuilder()
                .setHotelName("Lila Palace")
                .setHotelAddress("BTM 1st Stage Bangalore")
                .setRegion(region)
                .setHotelRatings(5)
                .getHotel();

        Hotel hotel1 = HotelBuilder
                .createHotelBuilder()
                .setHotelName("Lila Palace")
                .setHotelAddress("BTM 1st Stage Bangalore")
                .setHotelRatings(5)
                .setRegion(region)
                .getHotel();

        Hotel hotel2 = HotelBuilder
                .createHotelBuilder()
                .setHotelName("Army Hotel")
                .setHotelAddress("BTM 2st Stage Bangalore")
                .setRegion(region1)
                .setHotelRatings(5)
                .getHotel();

        Hotel hotel3 = HotelBuilder
                .createHotelBuilder()
                .setHotelName("Surya Hotel")
                .setHotelAddress("BTM 2st Stage Bangalore")
                .setRegion(region1)
                .setHotelRatings(5)
                .getHotel();

        ArrayList<Hotel> hotelArrayList = new ArrayList<>();
        hotelArrayList.add(hotel);
        hotelArrayList.add(hotel1);
        when(regionRepository.findByRegionName("NORTH_INDIAN")).thenReturn(region);
        when(hotelRepository.findByRegion(region)).thenReturn(hotelArrayList);
        when(hotelsController.getHotelByRegion("NORTH_INDIAN")).thenReturn((Iterable<Hotel>) hotelArrayList);
        when(RestPreconditions.checkFound(hotelRepository.findByRegion(region))).thenReturn(hotelArrayList);
        Iterable<Hotel> hotelsIterable = hotelsController.getHotelByRegion("NORTH_INDIAN");
        assertNotNull(hotelsIterable);
        verify(hotelRepository, times(1)).findByRegion(region);
    }
}
