package com.tomi.parking.services;

import com.tomi.parking.controller.dto.LocationWsDTO;
import com.tomi.parking.repository.LocationRepository;
import com.tomi.parking.repository.VehicleRepository;
import com.tomi.parking.repository.entity.Location;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ParkingServiceTest {

    @Mock
    private LocationRepository repository;

    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private LocationService service;

    @Captor
    ArgumentCaptor<Location> captor;

    @Test
    void testSaveLocation() {
        LocationWsDTO loc = new LocationWsDTO(42D, 42D, "honda");
        service.createLocation(loc);

        verify(repository).save(captor.capture());
        Location saved = captor.getValue();
    }
}

