package kz.gcs.rest.service;


import kz.gcs.rest.model.Location;

/**
 * Created by kaydar on 10/17/16.
 */
public interface LocationService {

    Long getGadgetIdByLogin(String login);

    void insertLocation(Location location);
}
