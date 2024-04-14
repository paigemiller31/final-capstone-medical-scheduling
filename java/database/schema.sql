BEGIN TRANSACTION;


DROP TABLE IF EXISTS  patient, doctor, office, users CASCADE;
	

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
    appointment_id int,
    patient_id int,
    doctor_id int,
    appointment_date DATE,
    appointment_time TIMESTAMP,
    duration int,
    available BOOLEAN,
    alert BOOLEAN,
     CONSTRAINT pk_appointment PRIMARY KEY (appointment_id)

);


COMMIT TRANSACTION;

