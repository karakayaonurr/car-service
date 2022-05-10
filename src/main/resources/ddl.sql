CREATE TABLE car
(
    id           int8        NOT NULL,
    created_date timestamptz NOT NULL,
    updated_date timestamptz NOT NULL,
    brand        varchar(255) NULL,
    color        int4 NULL,
    gear         int4 NULL,
    model        varchar(255) NULL,
    model_year   int8 NULL,
    "type"       int4 NULL,
    CONSTRAINT car_pkey PRIMARY KEY (id)
);

CREATE TABLE projectcars.users
(
    id        bigserial NOT NULL,
    address   varchar(255) NULL,
    birh_year int8 NULL,
    budget    int8 NULL,
    gender    int4 NULL,
    gsm_no    varchar(255) NULL,
    "name"    varchar(255) NULL,
    surname   varchar(255) NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);