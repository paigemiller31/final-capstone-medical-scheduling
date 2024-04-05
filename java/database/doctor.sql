-- Table: public.doctor

-- DROP TABLE public.doctor;

CREATE TABLE IF NOT EXISTS public.doctor
(
    doctor_id integer,
    user_id integer,
    address character varying(256) COLLATE pg_catalog."default",
    first_name character varying(64) COLLATE pg_catalog."default",
    last_name character varying(64) COLLATE pg_catalog."default",
    email character varying(64) COLLATE pg_catalog."default"
)

TABLESPACE pg_default;

ALTER TABLE public.doctor
    OWNER to postgres;