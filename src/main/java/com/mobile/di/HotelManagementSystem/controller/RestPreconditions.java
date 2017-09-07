package com.mobile.di.HotelManagementSystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * Created by Praveenkumar on 9/7/2017.
 * RestPreconditions for all null checks for controller layer checks
 */
public class RestPreconditions {

    private static final Logger logger = LoggerFactory.getLogger(RestPreconditions.class);

    public static <T> T checkFound(final T resource) throws IllegalArgumentException {
        if (resource == null
                || (resource instanceof Collection
                && ((Collection) resource).isEmpty())
                || (resource instanceof Iterable
                && !((Iterable) resource).iterator().hasNext())) {
            throw new IllegalArgumentException();
        }
        return resource;
    }
}
