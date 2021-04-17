--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-04-17 20:58:54 EEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 16386)
-- Name: nfqjava; Type: SCHEMA; Schema: -; Owner: nfqjava
--

CREATE SCHEMA nfqjava;


ALTER SCHEMA nfqjava OWNER TO nfqjava;

--
-- TOC entry 3032 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA nfqjava; Type: COMMENT; Schema: -; Owner: nfqjava
--

COMMENT ON SCHEMA nfqjava IS 'main schema for nfqjava';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 16490)
-- Name: customers; Type: TABLE; Schema: nfqjava; Owner: nfqjava
--

CREATE TABLE nfqjava.customers (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE nfqjava.customers OWNER TO nfqjava;

--
-- TOC entry 201 (class 1259 OID 16420)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: nfqjava; Owner: nfqjava
--

CREATE SEQUENCE nfqjava.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE nfqjava.hibernate_sequence OWNER TO nfqjava;

--
-- TOC entry 203 (class 1259 OID 16495)
-- Name: reservations; Type: TABLE; Schema: nfqjava; Owner: nfqjava
--

CREATE TABLE nfqjava.reservations (
    id bigint NOT NULL,
    customer_secret character varying(255),
    is_finished boolean NOT NULL,
    is_visiting boolean NOT NULL,
    short_id integer NOT NULL,
    time_added bigint,
    time_ended bigint,
    time_started bigint,
    customer_fk bigint,
    specialist_fk bigint
);


ALTER TABLE nfqjava.reservations OWNER TO nfqjava;

--
-- TOC entry 205 (class 1259 OID 16502)
-- Name: roles; Type: TABLE; Schema: nfqjava; Owner: nfqjava
--

CREATE TABLE nfqjava.roles (
    id integer NOT NULL,
    role_name character varying(255)
);


ALTER TABLE nfqjava.roles OWNER TO nfqjava;

--
-- TOC entry 204 (class 1259 OID 16500)
-- Name: roles_id_seq; Type: SEQUENCE; Schema: nfqjava; Owner: nfqjava
--

CREATE SEQUENCE nfqjava.roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE nfqjava.roles_id_seq OWNER TO nfqjava;

--
-- TOC entry 3033 (class 0 OID 0)
-- Dependencies: 204
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: nfqjava; Owner: nfqjava
--

ALTER SEQUENCE nfqjava.roles_id_seq OWNED BY nfqjava.roles.id;


--
-- TOC entry 206 (class 1259 OID 16508)
-- Name: specialists; Type: TABLE; Schema: nfqjava; Owner: nfqjava
--

CREATE TABLE nfqjava.specialists (
    id bigint NOT NULL,
    email character varying(255),
    full_name character varying(255),
    is_enabled boolean NOT NULL,
    password character varying(255)
);


ALTER TABLE nfqjava.specialists OWNER TO nfqjava;

--
-- TOC entry 207 (class 1259 OID 16516)
-- Name: specialists_roles; Type: TABLE; Schema: nfqjava; Owner: nfqjava
--

CREATE TABLE nfqjava.specialists_roles (
    specialist_id bigint NOT NULL,
    roles_id integer NOT NULL
);


ALTER TABLE nfqjava.specialists_roles OWNER TO nfqjava;

--
-- TOC entry 2873 (class 2604 OID 16505)
-- Name: roles id; Type: DEFAULT; Schema: nfqjava; Owner: nfqjava
--

ALTER TABLE ONLY nfqjava.roles ALTER COLUMN id SET DEFAULT nextval('nfqjava.roles_id_seq'::regclass);


--
-- TOC entry 3021 (class 0 OID 16490)
-- Dependencies: 202
-- Data for Name: customers; Type: TABLE DATA; Schema: nfqjava; Owner: nfqjava
--

COPY nfqjava.customers (id, name) FROM stdin;
82	Name
84	Name2
86	Name3
88	Name4
90	test
92	name6
94	name6
96	name7
\.


--
-- TOC entry 3022 (class 0 OID 16495)
-- Dependencies: 203
-- Data for Name: reservations; Type: TABLE DATA; Schema: nfqjava; Owner: nfqjava
--

COPY nfqjava.reservations (id, customer_secret, is_finished, is_visiting, short_id, time_added, time_ended, time_started, customer_fk, specialist_fk) FROM stdin;
83	ubV4Rui1xrKzRyFt	t	f	3263	1618680041	1618680055	1618680051	82	0
85	LSb2aV7SWoM7QYAf	t	f	6025	1618680062	1618680101	1618680067	84	0
87	xXrXNvQiVTrjIugV	t	f	7874	1618680112	1618680161	1618680115	86	0
89	xi7DKvC1XxZuLGlU	t	f	348	1618680172	1618680285	1618680200	88	0
91	th9GzmsvtOIatIV3	t	f	3254	1618680404	\N	\N	90	0
93	Yxo2kOZhMlnvLGO4	f	f	9047	1618680533	\N	\N	92	0
95	aTtbnC5WOvqq29HZ	f	f	8879	1618681060	\N	\N	94	0
97	5ou716rxA1ERmgqm	f	t	6319	1618681074	\N	1618681083	96	0
\.


--
-- TOC entry 3024 (class 0 OID 16502)
-- Dependencies: 205
-- Data for Name: roles; Type: TABLE DATA; Schema: nfqjava; Owner: nfqjava
--

COPY nfqjava.roles (id, role_name) FROM stdin;
\.


--
-- TOC entry 3025 (class 0 OID 16508)
-- Dependencies: 206
-- Data for Name: specialists; Type: TABLE DATA; Schema: nfqjava; Owner: nfqjava
--

COPY nfqjava.specialists (id, email, full_name, is_enabled, password) FROM stdin;
0	test@email.com	John Smith	t	$2a$10$JQsxfQ5PtLmXR9r9pqq8bOI4t5hmgHaftsCKLAk1A6SEultz/csMW
1	test2@email.com	Jane Doe	t	$2a$10$JQsxfQ5PtLmXR9r9pqq8bOI4t5hmgHaftsCKLAk1A6SEultz/csMW
\.


--
-- TOC entry 3026 (class 0 OID 16516)
-- Dependencies: 207
-- Data for Name: specialists_roles; Type: TABLE DATA; Schema: nfqjava; Owner: nfqjava
--

COPY nfqjava.specialists_roles (specialist_id, roles_id) FROM stdin;
\.


--
-- TOC entry 3034 (class 0 OID 0)
-- Dependencies: 201
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: nfqjava; Owner: nfqjava
--

SELECT pg_catalog.setval('nfqjava.hibernate_sequence', 97, true);


--
-- TOC entry 3035 (class 0 OID 0)
-- Dependencies: 204
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: nfqjava; Owner: nfqjava
--

SELECT pg_catalog.setval('nfqjava.roles_id_seq', 1, false);


--
-- TOC entry 2875 (class 2606 OID 16494)
-- Name: customers customers_pkey; Type: CONSTRAINT; Schema: nfqjava; Owner: nfqjava
--

ALTER TABLE ONLY nfqjava.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (id);


--
-- TOC entry 2877 (class 2606 OID 16499)
-- Name: reservations reservations_pkey; Type: CONSTRAINT; Schema: nfqjava; Owner: nfqjava
--

ALTER TABLE ONLY nfqjava.reservations
    ADD CONSTRAINT reservations_pkey PRIMARY KEY (id);


--
-- TOC entry 2879 (class 2606 OID 16507)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: nfqjava; Owner: nfqjava
--

ALTER TABLE ONLY nfqjava.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- TOC entry 2881 (class 2606 OID 16515)
-- Name: specialists specialists_pkey; Type: CONSTRAINT; Schema: nfqjava; Owner: nfqjava
--

ALTER TABLE ONLY nfqjava.specialists
    ADD CONSTRAINT specialists_pkey PRIMARY KEY (id);


--
-- TOC entry 2883 (class 2606 OID 16520)
-- Name: specialists_roles specialists_roles_pkey; Type: CONSTRAINT; Schema: nfqjava; Owner: nfqjava
--

ALTER TABLE ONLY nfqjava.specialists_roles
    ADD CONSTRAINT specialists_roles_pkey PRIMARY KEY (specialist_id, roles_id);


--
-- TOC entry 2885 (class 2606 OID 16522)
-- Name: specialists_roles uk_niu8y497wnng56udsllcorfnb; Type: CONSTRAINT; Schema: nfqjava; Owner: nfqjava
--

ALTER TABLE ONLY nfqjava.specialists_roles
    ADD CONSTRAINT uk_niu8y497wnng56udsllcorfnb UNIQUE (roles_id);


--
-- TOC entry 2888 (class 2606 OID 16533)
-- Name: specialists_roles fk59so3r9ostgfgp7b1bg1yd5sw; Type: FK CONSTRAINT; Schema: nfqjava; Owner: nfqjava
--

ALTER TABLE ONLY nfqjava.specialists_roles
    ADD CONSTRAINT fk59so3r9ostgfgp7b1bg1yd5sw FOREIGN KEY (roles_id) REFERENCES nfqjava.roles(id);


--
-- TOC entry 2886 (class 2606 OID 16523)
-- Name: reservations fkd73bfh5kql8akbsshtmqugd1m; Type: FK CONSTRAINT; Schema: nfqjava; Owner: nfqjava
--

ALTER TABLE ONLY nfqjava.reservations
    ADD CONSTRAINT fkd73bfh5kql8akbsshtmqugd1m FOREIGN KEY (customer_fk) REFERENCES nfqjava.customers(id);


--
-- TOC entry 2889 (class 2606 OID 16538)
-- Name: specialists_roles fkjk5k8mbwj1mplyl6iia6xebmp; Type: FK CONSTRAINT; Schema: nfqjava; Owner: nfqjava
--

ALTER TABLE ONLY nfqjava.specialists_roles
    ADD CONSTRAINT fkjk5k8mbwj1mplyl6iia6xebmp FOREIGN KEY (specialist_id) REFERENCES nfqjava.specialists(id);


--
-- TOC entry 2887 (class 2606 OID 16528)
-- Name: reservations fkoyinyrlq17pb21mpiet4sgeqf; Type: FK CONSTRAINT; Schema: nfqjava; Owner: nfqjava
--

ALTER TABLE ONLY nfqjava.reservations
    ADD CONSTRAINT fkoyinyrlq17pb21mpiet4sgeqf FOREIGN KEY (specialist_fk) REFERENCES nfqjava.specialists(id);


-- Completed on 2021-04-17 20:58:54 EEST

--
-- PostgreSQL database dump complete
--

