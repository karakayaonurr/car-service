-- projectcars.car definition

-- Drop table

-- DROP TABLE projectcars.car;

CREATE TABLE projectcars.car
(
    id           bigserial   NOT NULL,
    created_date timestamptz NOT NULL,
    updated_date timestamptz NOT NULL,
    brand        varchar(255) NULL,
    color        int4 NULL,
    gear         int4 NULL,
    model        varchar(255) NULL,
    model_year   int8 NULL,
    price        numeric(19, 2) NULL,
    "type"       int4 NULL,
    CONSTRAINT   car_pkey null
);

-- projectcars.users definition

-- Drop table

-- DROP TABLE projectcars.users;

CREATE TABLE projectcars.users
(
    id         bigserial NOT NULL,
    address    varchar(255) NULL,
    birth_year int8 NULL,
    budget     numeric(19, 2) NULL,
    gender     int4 NULL,
    gsm_no     varchar(255) NULL,
    "name"     varchar(255) NULL,
    surname    varchar(255) NULL,
    CONSTRAINT users_pkey null
);

-- projectcars.orders definition

-- Drop table

-- DROP TABLE projectcars.orders;

CREATE TABLE projectcars.orders
(
    id         bigserial NOT NULL,
    price      numeric(19, 2) NULL,
    user_id    int8 NULL,
    CONSTRAINT orders_pkey null
);


-- projectcars.orders foreign keys

ALTER TABLE projectcars.orders
    ADD CONSTRAINT fk32ql8ubntj5uh44ph9659tiih null;