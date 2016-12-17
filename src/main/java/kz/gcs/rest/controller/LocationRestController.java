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
import org.springframework.web.util.UriComponentsBuilder;

import kz.gcs.rest.model.User;

@RestController
public class LocationRestController {

    @Autowired
    LocationService locationService;  //Service which will do all data retrieval/manipulation work

    private final static Logger logger = Logger.getLogger(LocationRestController.class);

    @RequestMapping(value = "/sync/", method = RequestMethod.POST)
    public ResponseEntity<Boolean> listAllUsers(@RequestParam Map<String, String> requestParams) {

        logger.info("NEW REQUEST " + requestParams);

        logger.info("DATE " + new Date(Long.parseLong(requestParams.get("date"))));


        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);

        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }


}
