--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

-- Started on 2024-05-31 20:12:19 WIB

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 216 (class 1259 OID 16403)
-- Name: word; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.word (
    id integer NOT NULL,
    japanese character varying(100),
    cara_baca character varying(200),
    english character varying(200),
    section integer,
    chapter integer,
    mastery integer
);


ALTER TABLE public.word OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16402)
-- Name: word_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.word_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.word_id_seq OWNER TO postgres;

--
-- TOC entry 3596 (class 0 OID 0)
-- Dependencies: 215
-- Name: word_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.word_id_seq OWNED BY public.word.id;


--
-- TOC entry 3443 (class 2604 OID 16406)
-- Name: word id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.word ALTER COLUMN id SET DEFAULT nextval('public.word_id_seq'::regclass);


--
-- TOC entry 3590 (class 0 OID 16403)
-- Dependencies: 216
-- Data for Name: word; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.word (id, japanese, cara_baca, english, section, chapter, mastery) FROM stdin;
1	一家	ikka	Family	1	1	0
2	ありがたい	arigatai	Grateful	1	1	0
3	向き合う	mukiau	Face	1	1	0
4	つくづく	tsuduku	Deeply/Greatly	1	1	0
5	養う	yashinau	Provide for	1	1	0
6	役目	yakume	duty	1	1	0
7	甘える	amaeru	to be spoiled, to be dependent	1	1	0
8	世間知らず	sekenshirazu	ignorant of the outside world/inexperienced	1	1	0
9	しつけ	shitsuke	discipline	1	1	0
10	言い付ける	iidukeru	tell	1	1	0
11	自立する	jiritsusuru	independence	1	1	0
12	言い出す	iidasu	start saying	1	1	0
13	意思	ishi	intention	1	1	0
14	尊重	sonchou	respect	1	1	0
\.


--
-- TOC entry 3597 (class 0 OID 0)
-- Dependencies: 215
-- Name: word_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.word_id_seq', 3, true);


--
-- TOC entry 3445 (class 2606 OID 16408)
-- Name: word word_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.word
    ADD CONSTRAINT word_pkey PRIMARY KEY (id);


-- Completed on 2024-05-31 20:12:19 WIB

--
-- PostgreSQL database dump complete
--

