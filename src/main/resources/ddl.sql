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