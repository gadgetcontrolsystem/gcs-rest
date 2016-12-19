package kz.gcs.rest.service.impl;

import kz.gcs.rest.model.Location;
import kz.gcs.rest.service.LocationService;
import kz.gcs.rest.service.dao.LocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by kaydar on 10/17/16.
 */
@Component
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationDao locationDao;


    public Long getGadgetIdByLogin(String login) {

        return locationDao.getGadgetIdByLogin(login);
    }

    public void insertLocation(Location location) {
        locationDao.insLocation(location);
    }
}
