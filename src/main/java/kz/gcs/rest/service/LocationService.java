package kz.gcs.rest.service;


import kz.gcs.rest.model.Location;

import java.util.List;

/**
 * Created by kaydar on 10/17/16.
 */
public interface LocationService {
    Location getLastLocation(long gadgetId);

    List<Location> getLocations(long gadgetId);
}
