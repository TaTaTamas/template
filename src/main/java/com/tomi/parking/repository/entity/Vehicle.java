package com.tomi.parking.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Vehicle {


/*
    id VARCHAR(36) primary key default gen_random_uuid(),
    vname VARCHAR(255) not null,
    vtype vehicle_type NOT NULL DEFAULT 'CAR'
 */

    @Id
    @GeneratedValue(generator = "UUID")
    private String id;

    @Column(nullable = false)
    private String vname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VehicleType vtype;

    @ManyToMany(mappedBy = "vehicles")
    private Set<Users> users;

    @OneToMany(mappedBy = "vehicle")
    private Set<Location> locations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public VehicleType getVtype() {
        return vtype;
    }

    public void setVtype(VehicleType vtype) {
        this.vtype = vtype;
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }
}
