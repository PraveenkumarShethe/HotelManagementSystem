package com.mobile.di.HotelManagementSystem.controller;

import com.mobile.di.HotelManagementSystem.model.Hotel;
import com.mobile.di.HotelManagementSystem.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    /**
     * @return An iterable of the list of hotels without filter
     * Http.ok will be returned{@code 200 OK}.
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
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Transactional(Transactional.TxType.NEVER)
    public Hotel getHotelById(@PathVariable("id") Long id) {
        return hotelRepository.findOne(id);
    }
}
