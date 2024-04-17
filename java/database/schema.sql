BEGIN TRANSACTION;


DROP TABLE IF EXISTS  appointment, reviews, patient, doctor, office, users CASCADE;
	

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS office
(
	office_id SERIAL,
	office_name VARCHAR (64),
	address_line_1 VARCHAR (128) ,
	address_line_2   VARCHAR (128),
	city  VARCHAR (64),
	state VARCHAR (64),
	zip_code VARCHAR (15),
	phone_number VARCHAR(15),
	email VARCHAR(64),
	office_hours VARCHAR(30),
	CONSTRAINT PK_office PRIMARY KEY (office_id)

	);

CREATE TABLE IF NOT EXISTS patient
(
    patient_id int,
    first_name VARCHAR (64),
    last_name VARCHAR (64) ,
	phone_number VARCHAR(15),
    email VARCHAR(64),
	address_line_1 VARCHAR (128) ,
	address_line_2   VARCHAR (128),
	city  VARCHAR (64),
	state VARCHAR (64),
	zip_code VARCHAR (15),
	CONSTRAINT PK_patient PRIMARY KEY (patient_id),
	CONSTRAINT FK_patient_users FOREIGN KEY (patient_id) REFERENCES users (user_id)
);

CREATE TABLE IF NOT EXISTS doctor
(
    doctor_id int,
    office_id int ,
    first_name VARCHAR (64),
    last_name VARCHAR (64) ,
	specialization VARCHAR (64),
	cost_per_hour int,
	CONSTRAINT PK_doctor PRIMARY KEY (doctor_id),
    CONSTRAINT FK_doctor_users FOREIGN KEY (doctor_id) REFERENCES users (user_id),
    CONSTRAINT FK_doctor_office FOREIGN KEY (office_id) REFERENCES office (office_id)
);

CREATE TABLE IF NOT EXISTS appointment

(
    appointment_id SERIAL,
    patient_id integer,
    doctor_id integer,
    appointment_date date,
    appointment_time TIME,
    duration integer,
    available boolean,
    alert boolean,
    CONSTRAINT PK_appointment PRIMARY KEY (appointment_id),
    CONSTRAINT FK_appointment_doctor FOREIGN KEY (doctor_id) REFERENCES doctor (doctor_id),
    CONSTRAINT FK_appointment_patient FOREIGN KEY (patient_id) REFERENCES patient (patient_id)

);


CREATE TABLE IF NOT EXISTS reviews
(
    review_id SERIAL,
    office_id int,
    stars int,
    review VARCHAR (256),
	response VARCHAR (256),
	CONSTRAINT PK_review PRIMARY KEY (review_id),
	CONSTRAINT FK_review_office FOREIGN KEY (office_id) REFERENCES office (office_id)

);

DROP VIEW IF EXISTS dr_date_appointments;
DROP VIEW IF EXISTS dr_off_hours ;
DROP TABLE IF EXISTS office_appt_hours ;

CREATE TABLE office_appt_hours (
	id serial PRIMARY KEY,
	office_id int,
	time_block time without time zone
);

INSERT INTO office_appt_hours (office_id, time_block)
VALUES
	(1, '09:00'),
	(1, '10:00'),
	(1, '11:00'),
	(1, '12:00'),
	(1, '13:00'),
	(1, '14:00'),
	(1, '15:00'),
	(1, '16:00'),

	(2, '09:00'),
	(2, '10:00'),
	(2, '11:00'),
	(2, '12:00'),
	(2, '13:00'),
	(2, '14:00'),
	(2, '15:00'),
	(2, '16:00'),

	(3, '09:00'),
	(3, '10:00'),
	(3, '11:00'),
	(3, '12:00'),
	(3, '13:00'),
	(3, '14:00'),
	(3, '15:00'),
	(3, '16:00'),

	(4, '09:00'),
	(4, '10:00'),
	(4, '11:00'),
	(4, '12:00'),
	(4, '13:00'),
	(4, '14:00'),
	(4, '15:00'),
	(4, '16:00');

CREATE VIEW dr_off_hours AS
SELECT
    oah.office_id, dr.doctor_id, oah.time_block
FROM    office_appt_hours oah
        LEFT OUTER JOIN doctor dr
            ON dr.office_id = oah.office_id
ORDER BY oah.office_id, dr.doctor_id, time_block;

CREATE VIEW dr_date_appointments AS
SELECT
    doh.office_id,
    doh.doctor_id,
    doh.time_block,
    appt.appointment_id,
    appt.patient_id,
    appt.appointment_date,
    appt.appointment_time,
    appt.duration,
    appt.available,
    appt.alert

FROM
    dr_off_hours doh
        LEFT OUTER JOIN appointment appt
            ON 	doh.doctor_id = appt.doctor_id
                AND
					(doh.time_block = appt.appointment_time
					 OR
					 appt.appointment_time IS NULL
					 )
--WHERE
--	doh.doctor_id = 3
--	AND
--	(appt.appointment_date = '2017-03-17' OR appt.appointment_date is null)
ORDER BY
    doh.office_id,
    doh.doctor_id,
    doh.time_block;

COMMIT TRANSACTION;

