package com.mobile.di.HotelManagementSystem.controller.restexceptionhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Praveenkumar on 3/8/2017.
 */
public class HMSResourceNotFoundException extends Exception{

    private static Logger logger = LoggerFactory.getLogger(HMSResourceNotFoundException.class);

    public HMSResourceNotFoundException(){super();}

    public HMSResourceNotFoundException(final String message , final Throwable throwable){
        super(message , throwable);
        logger.info(message + "----------" + throwable.getCause());
    }

    public HMSResourceNotFoundException(final String message){
        super(message);
        logger.info(message);
    }

    public HMSResourceNotFoundException(final Throwable throwable){
        super(throwable);
        logger.info(throwable.getMessage());
        logger.info(throwable.getCause().toString());
    }
}

