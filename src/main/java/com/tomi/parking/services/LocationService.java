package com.tomi.parking.services;

import com.tomi.parking.controller.dto.LocationDetailsWsDTO;
import com.tomi.parking.controller.dto.LocationListWsDTO;
import com.tomi.parking.controller.dto.LocationWsDTO;
import com.tomi.parking.repository.LocationRepository;
import com.tomi.parking.repository.VehicleRepository;
import com.tomi.parking.repository.entity.Location;
import com.tomi.parking.repository.entity.Vehicle;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class LocationService {

    @Resource
    private LocationRepository locationRepository;

    @Resource
    private VehicleRepository vehicleRepository;

    public void createLocation(final LocationWsDTO locationWsDTO) {
        Vehicle vehicle = getVehicle(locationWsDTO.vehicleId());

        Location location = new Location();
        location.setLatitude(locationWsDTO.latitude());
        location.setLongitude(locationWsDTO.longitude());
        location.setVehicle(vehicle);
        location.setSavedate(new Date());
        location.setWeekday(true);

        locationRepository.save(location);

        //vehicle.getLocations().add(location);
        //vehicleRepository.save(vehicle);
    }

    public LocationListWsDTO getLocations(String vehicleID) {
        Vehicle vehicle = getVehicle(vehicleID);
        Set<Location> locationSet = vehicle.getLocations();
        List<LocationDetailsWsDTO> locationDetailsWsDTOList = locationSet.stream().map(location -> {
            return new LocationDetailsWsDTO(location.getLatitude(), location.getLongitude(), location.getSavedate());

        }).toList();
        return new LocationListWsDTO(locationDetailsWsDTOList);

    }

    private Vehicle getVehicle(String vehicleID) {
        Vehicle vehicle =  vehicleRepository.findByVname(vehicleID);
        if (vehicle == null) {
            throw new RuntimeException("vehicle not found");
        }
        return vehicle;
    }
}
