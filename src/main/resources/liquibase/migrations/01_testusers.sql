-- liquibase formatted sql

-- changeset @tomi:2

INSERT INTO users (id, email, uname)
VALUES
    (gen_random_uuid(), 'neo@example.com', 'neo'),
    (gen_random_uuid(), 'trinity@example.com', 'trinity'),
    (gen_random_uuid(), 'morpheus@example.com', 'morpheus');
