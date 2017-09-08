package com.mobile.di.HotelManagementSystem.controller;

import com.mobile.di.HotelManagementSystem.controller.restexceptionhandler.HMSResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * Created by Praveenkumar on 9/7/2017.
 * RestPreconditions for all null checks for controller layer checks
 */
public class RestPreconditions {

    /**
     * The org.slf4j.Logger interface is the main user entry point of SLF4J API.
     * It is expected that logging takes place through concrete implementations
     * of this interface.
     * Logger is AOP concept and helps in finding bugs and other details of enter points
     * @param RestPreconditions
     *
     */
    private static final Logger logger = LoggerFactory.getLogger(RestPreconditions.class);

    public static <T> T checkFound(final T resource) throws HMSResourceNotFoundException {
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
