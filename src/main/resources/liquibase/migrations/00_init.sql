-- liquibase formatted sql

-- changeset @tomi:1



create table if not exists users
(
    id VARCHAR(36) primary key default gen_random_uuid(),
    email VARCHAR(255) not null UNIQUE,
    uname VARCHAR(255) not null
);



/*
CREATE TYPE vehicle_type AS ENUM ('CAR', 'MOTOR', 'BYCICLE');
DO $$
BEGIN
   IF NOT EXISTS (
      SELECT 1 FROM pg_type WHERE typname = 'vehicle_type'
   ) THEN
      CREATE TYPE vehicle_type AS ENUM ('CAR', 'MOTOR', 'BYCICLE');
   END IF;
END
$$;
*/


create table if not exists vehicle
(
    id VARCHAR(36) primary key default gen_random_uuid(),
    vname VARCHAR(255) not null,
    vtype vehicle_type NOT NULL DEFAULT 'CAR'
);

CREATE TABLE if not exists user_vehicle
(
    user_id VARCHAR(36) NOT NULL,
    vehicle_id VARCHAR(36) NOT NULL,
    PRIMARY KEY (user_id, vehicle_id),
    CONSTRAINT fk_uservehicle_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_uservehicle_vehicle FOREIGN KEY (vehicle_id) REFERENCES vehicle(id)
);

create table if not exists location
(
    id VARCHAR(36) primary key default gen_random_uuid(),
    vehicle_id VARCHAR(36) not null,
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    savedate DATE,
    weekday BOOLEAN NOT NULL,
    CONSTRAINT fk_location_vehicle FOREIGN KEY (vehicle_id) REFERENCES vehicle(id)
)