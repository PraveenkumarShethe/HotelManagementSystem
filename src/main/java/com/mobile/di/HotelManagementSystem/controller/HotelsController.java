package com.mobile.di.HotelManagementSystem.controller;

import com.mobile.di.HotelManagementSystem.controller.restexceptionhandler.HMSResourceNotFoundException;
import com.mobile.di.HotelManagementSystem.model.Hotel;
import com.mobile.di.HotelManagementSystem.model.Region;
import com.mobile.di.HotelManagementSystem.repository.HotelRepository;
import com.mobile.di.HotelManagementSystem.repository.RegionRepository;
import com.mobile.di.HotelManagementSystem.service.serviceImpl.HotelServiceInterface;
import com.mobile.di.HotelManagementSystem.validator.HotelValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

/**
 * Created by Praveenkumar on 9/7/2017.
 * Controller class to handle REST API calles to /hotels/**
 */
@RestController
@RequestMapping(value = "/hotels", produces = MediaType.APPLICATION_JSON_VALUE)
public class HotelsController {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private HotelServiceInterface hotelServiceInterface;
    @Autowired
    private HotelValidator hotelValidator;
    @Autowired
    private RegionRepository regionRepository;

    /**
     * @return An iterable of the list of hotels without filter
     * Http.ok will be returned{@code 200 OK}.
     * Http.NOT_FOUND will be returned if not found {@code 404 Not Found}.
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Transactional(Transactional.TxType.NEVER)
    public Iterable<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    /**
     * @param id The record id of the Hotel that will be queried
     * @return THe Hotel object
     * Http.ok will be returned{@code 200 OK}.
     * Http.NOT_FOUND will be returned if not found {@code 404 Not Found}.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Transactional(Transactional.TxType.NEVER)
    public Hotel getHotelById(@PathVariable("id") Long id) throws HMSResourceNotFoundException {
        return RestPreconditions.checkFound(hotelRepository.findOne(id));
    }

    /**
     * @param regionName The record regionName of the Hotel that will be queried
     * @return The Iterable Hotel object
     * Http.ok will be returned{@code 200 OK}.
     * Http.NOT_FOUND will be returned if not found {@code 404 Not Found}.
     * Http.BAD_REQUEST will be returned if not found {@code 400 Bad Request}.
     */
    @RequestMapping(value = "/searchByRegionName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Transactional(Transactional.TxType.NEVER)
    public Iterable<Hotel> getHotelByRegion(@RequestParam("regionName") String regionName) throws HMSResourceNotFoundException {
        Region region = regionRepository.findByRegionName(regionName);
        return RestPreconditions.checkFound(hotelRepository.findByRegion(region));
    }

    /**
     * Add a new Hotel to the Hotel database.
     * @param hotel The Hotel object to be inserted
     * {@code 201 Created}. for creating an object
     * {@code 400 Bad Request}. for all other requests
     */
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void insertNewHotel(@RequestBody Hotel hotel) {
        Iterable<Hotel> duplicateHotel = hotelRepository.findAll();
        duplicateHotel.forEach(hotel1 -> {
            if (hotel.getHotelName().equals(hotel.getHotelName())) {
                throw new IllegalArgumentException("Hotel already exists in the database");
            }
        });
        hotelValidator.validate(hotel);
        hotelServiceInterface.saveHotel(hotel);
    }

    /**
     * Add a new Hotel to the Hotel database.
     * @param updateHotel The Hotel object to be inserted
     * {@code 205 Reset Content} for Updating an Hotel object
     * {@code 400 Bad Request} for all other requests eg. JSON mismatch like wise
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void updateHotelDetails(@PathVariable("id") Long hotelid, @RequestBody Hotel updateHotel) throws HMSResourceNotFoundException {
        Hotel hotel = RestPreconditions.checkFound(hotelRepository.findOne(hotelid));
        hotelServiceInterface.updateHotel(updateHotel, hotel);
    }

}
