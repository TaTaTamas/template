package com.tomi.parking.controller;

import com.tomi.parking.controller.dto.LocationListWsDTO;
import com.tomi.parking.controller.dto.LocationWsDTO;
import com.tomi.parking.services.LocationService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking")
public class LocationController {

    @Resource
    private LocationService locationService;

    @PostMapping(value = "/location")
    @ResponseStatus(HttpStatus.CREATED)
    public String createLocation( @RequestBody final LocationWsDTO locationWsDTO) {
        System.out.println("vehicleid = " + locationWsDTO.vehicleId());
        System.out.println("latitude = " + locationWsDTO.latitude());
        System.out.println("longitude = " + locationWsDTO.longitude());


        locationService.createLocation(locationWsDTO);
        return HttpStatus.CREATED.getReasonPhrase();
    }

    @GetMapping(value = "/locations")
    @ResponseStatus(HttpStatus.OK)
    public LocationListWsDTO readLocations(@RequestParam final String vehicleID) {
        return locationService.getLocations(vehicleID);
    }
}

// TODO: add Swagger