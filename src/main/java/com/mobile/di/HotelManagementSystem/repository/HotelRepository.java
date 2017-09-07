package com.mobile.di.HotelManagementSystem.repository;

import com.mobile.di.HotelManagementSystem.model.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by Praveenkumar on 9/7/2017.
 */
@Repository
@RestResource(exported = false)
public interface HotelRepository extends CrudRepository<Hotel,Long> {
}
