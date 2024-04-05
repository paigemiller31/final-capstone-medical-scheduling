-- Table: public.patient

-- DROP TABLE public.patient;

CREATE TABLE IF NOT EXISTS public.patient
(
    patient_id integer,
    user_id integer,
    first_name character varying(64) COLLATE pg_catalog."default",
    last_name character varying(64) COLLATE pg_catalog."default",
    address character varying(256) COLLATE pg_catalog."default",
    email character varying(64) COLLATE pg_catalog."default",
    phone_number character varying(15) COLLATE pg_catalog."default"
)

TABLESPACE pg_default;

ALTER TABLE public.patient
    OWNER to postgres;