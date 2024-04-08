-- Table: public.doctor

-- DROP TABLE public.doctor;
BEGIN TRANSACTION;

DROP TABLE IF EXISTS doctor;

CREATE TABLE IF NOT EXISTS doctor
(
        doctor_id int,
        user_id int,
        first_name VARCHAR (64),
        last_name VARCHAR (64) ,
    	phone_number VARCHAR(15),
        email VARCHAR(64),
    	email_reminder BOOLEAN,
    	address_line_1 VARCHAR (128) ,
    	address_line_2   VARCHAR (128),
    	city  VARCHAR (64),
    	state VARCHAR (64),
    	zip_code VARCHAR (15)
);

    GRANT UPDATE, DELETE, INSERT, SELECT ON TABLE public.doctor TO final_capstone_appuser;

    COMMIT TRANSACTION;
