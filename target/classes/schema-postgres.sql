
DROP DATABASE nfqjava
CREATE DATABASE nfqjava

CREATE TABLE customers
(
    id bigint NOT NULL,
    name character varying(255)[] NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE nfqjava.specialists
(
    id bigint NOT NULL,
    email character varying(250)[] NOT NULL,
    password character varying NOT NULL,
    PRIMARY KEY (id)
);