package com.mobile.di.HotelManagementSystem.repository;

import com.mobile.di.HotelManagementSystem.model.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by Praveenkumar on 9/7/2017.
 * RegionRepository Interface for generic CRUD operations on a repository for a specific type.
 */
@Repository
@RestResource(exported = false)
public interface RegionRepository extends CrudRepository<Region, Long> {

    Region findByRegionName(String regionName);

}
