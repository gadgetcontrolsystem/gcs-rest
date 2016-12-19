package kz.gcs.rest.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import kz.gcs.rest.model.Location;
import kz.gcs.rest.service.LocationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationRestController {

    @Autowired
    LocationService locationService;  //Service which will do all data retrieval/manipulation work

    private final static Logger logger = Logger.getLogger(LocationRestController.class);

    @RequestMapping(value = "/sync/", method = RequestMethod.POST)
    public ResponseEntity<Boolean> listAllUsers(@RequestParam Map<String, String> requestParams) {


        long dateInMilliseconds = Long.parseLong(requestParams.get("date"));
        Date date = new Date(dateInMilliseconds);

        double latitude = Double.parseDouble(requestParams.get("latitude"));
        double longitude = Double.parseDouble(requestParams.get("longitude"));
        double accuracy = Double.parseDouble(requestParams.get("accuracy"));
        String account = requestParams.get("username");

        if (account == null || account.length() == 0) {
            logger.info("Param account is empty, exiting service");
            return new ResponseEntity<Boolean>(false, HttpStatus.OK);
        }

        logger.info("NEW REQUEST from" + account);
        logger.info("DATE " + date);
        logger.info("latitude " + latitude);
        logger.info("longitude " + longitude);
        logger.info("accuracy " + accuracy);

        logger.info("Getting gadget_id for " + account);
        Long gId = locationService.getGadgetIdByLogin(account);
        logger.info("Found gadget_id for " + account + " is " + gId);

        if (gId == null) {
            logger.info("gadget_id for " + account + " NOT FOUND, exiting service");
            return new ResponseEntity<Boolean>(false, HttpStatus.OK);
        }

        Location newLoc = new Location(date, latitude, longitude, accuracy, gId);
        logger.info("Start inserting new location for " + account);
        locationService.insertLocation(newLoc);
        logger.info("Finish inserting new location for " + account);


        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }


}
