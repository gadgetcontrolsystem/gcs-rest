package kz.gcs.rest.service.dao;

import kz.gcs.rest.model.Location;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by kaydar on 10/17/16.
 */
@Mapper
public interface LocationDao {
    @Select("SELECT id,time, country, city, LONGTITUDE as lon, LATITUDE as lat, accuracy as accuracy, GADGET_ID as gadgetId FROM locations order by time desc limit 1")
    Location getLastLocation();


    @Select("SELECT id,time, country, city, LONGTITUDE as lon, LATITUDE as lat,accuracy as accuracy, GADGET_ID as gadgetId FROM locations")
    List<Location> getAllLocations();

}