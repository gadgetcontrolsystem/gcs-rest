package kz.gcs.rest.service.impl;

import kz.gcs.rest.model.Location;
import kz.gcs.rest.service.LocationService;
import kz.gcs.rest.service.dao.LocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by kaydar on 10/17/16.
 */
@Component
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationDao locationDao;

    @Override
    public Location getLastLocation(long gadgetId) {
        return locationDao.getLastLocation();
    }

    @Override
    public List<Location> getLocations(long gadgetId) {
        return locationDao.getAllLocations();
    }
}
