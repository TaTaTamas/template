-- liquibase formatted sql

-- changeset @tomi:3

INSERT INTO vehicle (id, vname, vtype)
VALUES
    (gen_random_uuid(), 'myhonda', 'CAR'),
    (gen_random_uuid(), 'batbike', 'MOTOR');

