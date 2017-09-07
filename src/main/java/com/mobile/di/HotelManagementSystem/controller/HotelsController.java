package com.mobile.di.HotelManagementSystem.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Praveenkumar on 9/7/2017.
 */
@RestController
@RequestMapping(value = "/hotels", produces = MediaType.APPLICATION_JSON_VALUE)
public class HotelsController {
}
