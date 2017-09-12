package com.mobile.di.HotelManagementSystem.controller;

import com.mobile.di.HotelManagementSystem.model.Region;
import com.mobile.di.HotelManagementSystem.repository.RegionRepository;
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
 * Controller class to handle REST API calles to /regions/**
 */
@RestController
@RequestMapping(value = "/regions", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegionController {

    @Autowired
    private RegionRepository regionRepository;

    /**
     * @return An iterable of the list of Region without filter
     * Http.ok will be returned{@code 200 OK}.
     * Http.NOT_FOUND will be returned if not found {@code 404 Not Found}.
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Transactional(Transactional.TxType.NEVER)
    public Iterable<Region> getAllRegion() {
        return regionRepository.findAll();
    }


    /**
     * @param id The record id of the Region that will be queried
     * @return THe Region object
     * Http.ok will be returned{@code 200 OK}.
     * Http.NOT_FOUND will be returned if not found {@code 404 Not Found}.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Transactional(Transactional.TxType.NEVER)
    public Region getRegionById(@PathVariable("id") Long id) {
        return regionRepository.findOne(id);
    }

}
