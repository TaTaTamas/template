package com.tomi.parking.repository;

import com.tomi.parking.repository.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, String> {


}
