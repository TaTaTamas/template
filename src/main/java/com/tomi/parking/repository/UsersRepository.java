package com.tomi.parking.repository;

import com.tomi.parking.repository.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {

    Users findByEmail(String email);
}
