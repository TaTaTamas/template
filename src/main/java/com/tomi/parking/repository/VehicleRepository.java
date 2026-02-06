package com.tomi.parking.repository;

import com.tomi.parking.repository.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,String> {

    Vehicle findByVname(String vname);
}
