package com.tomi.parking.repository.entity;

import jakarta.persistence.*;

import java.util.Set;


@Entity
public class Users {

    /*
    id VARCHAR(36) primary key default gen_random_uuid(),
    email VARCHAR(255) not null UNIQUE,
    uname VARCHAR(255) not null

 */

    @Id
    @GeneratedValue(generator = "UUID")
    private String id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String uname;

    @ManyToMany
    @JoinTable(name = "user_vehicle",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    private Set<Vehicle> vehicles;

    public Users(String id, String email, String uname, Set<Vehicle> vehicles) {
        this.id = id;
        this.email = email;
        this.uname = uname;
        this.vehicles = vehicles;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}

