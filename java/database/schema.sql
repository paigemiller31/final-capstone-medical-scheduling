BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS patient;

CREATE TABLE IF NOT EXISTS patient
(
    patient_id SERIAL,
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
	zip_code VARCHAR (15),
	CONSTRAINT PK_patient PRIMARY KEY (patient_id)

);

DROP TABLE IF EXISTS doctor;

CREATE TABLE IF NOT EXISTS doctor
(
    doctor_id SERIAL,
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
	zip_code VARCHAR (15),
	CONSTRAINT PK_doctor PRIMARY KEY (doctor_id)

);

DROP TABLE IF EXISTS office ;

CREATE TABLE IF NOT EXISTS office
(
       	office_id SERIAL,
        doctor_id int,
		patient_id int,
    	address_line_1 VARCHAR (128) ,
    	address_line_2   VARCHAR (128),
    	city  VARCHAR (64),
    	state VARCHAR (64),
    	zip_code VARCHAR (15),
	    phone_number VARCHAR(15),
        email VARCHAR(64),
		office_hours VARCHAR(15),
		cost_per_hour decimal ,
    	CONSTRAINT PK_office PRIMARY KEY (office_id)
);



COMMIT TRANSACTION;

