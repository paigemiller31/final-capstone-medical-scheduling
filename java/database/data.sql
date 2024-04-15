BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');

INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');




INSERT INTO users (username,password_hash,role) VALUES ('jasperkai','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_DOCTOR');
INSERT INTO doctor (doctor_id, first_name, last_name, specialization, cost_per_hour)
                VALUES ((select user_id from users where role = 'ROLE_DOCTOR' and username = 'jasperkai'),'Dr. Jasper', 'Kai', 'Psychiatrist', 65);


INSERT INTO users (username,password_hash,role) VALUES ('amarakhan','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_DOCTOR');
INSERT INTO doctor (doctor_id, first_name, last_name, specialization, cost_per_hour)
                VALUES ((select user_id from users where role = 'ROLE_DOCTOR' and username = 'amarakhan'),'Dr. Amara', 'Khan', 'Psychiatrist', 65);




INSERT INTO users (username,password_hash,role) VALUES ('indigogreen','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_DOCTOR');
INSERT INTO doctor (doctor_id, first_name, last_name, specialization, cost_per_hour)
                VALUES ((select user_id from users where role = 'ROLE_DOCTOR' and username = 'indigogreen'),'Dr. Indigo', 'Green', 'OB-GYN', 80);


INSERT INTO users (username,password_hash,role) VALUES ('lyrastone','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_DOCTOR');
INSERT INTO doctor (doctor_id, first_name, last_name, specialization, cost_per_hour)
                VALUES ((select user_id from users where role = 'ROLE_DOCTOR' and username = 'lyrastone'),'Dr. Lyra', 'Stone', 'OB-GYN', 80);




INSERT INTO users (username,password_hash,role) VALUES ('akikotanaka','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_DOCTOR');
INSERT INTO doctor (doctor_id, first_name, last_name, specialization, cost_per_hour)
                 VALUES ((select user_id from users where role = 'ROLE_DOCTOR' and username = 'akikotanaka'),'Dr. Akiko', 'Tanaka', 'Dermatologist', 80);


INSERT INTO users (username,password_hash,role) VALUES ('aishasharma','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_DOCTOR');
INSERT INTO doctor (doctor_id, first_name, last_name, specialization, cost_per_hour)
                  VALUES ((select user_id from users where role = 'ROLE_DOCTOR' and username = 'aishasharma'),'Dr. Aisha', 'Sharma', 'Dermatologist', 80);




INSERT INTO users (username,password_hash,role) VALUES ('deanmcdreamy','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_DOCTOR');
INSERT INTO doctor (doctor_id, first_name, last_name, specialization, cost_per_hour)
                VALUES ((select user_id from users where role = 'ROLE_DOCTOR' and username = 'deanmcdreamy'),'Dr. Dean', 'McDreamy', 'Radiologist', 120);


INSERT INTO users (username,password_hash,role) VALUES ('devpatel','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_DOCTOR');
INSERT INTO doctor (doctor_id, first_name, last_name, specialization, cost_per_hour)
                VALUES ((select user_id from users where role = 'ROLE_DOCTOR' and username = 'devpatel'),'Dr. Dev', 'Patel', 'Oncologist', 150);


INSERT INTO users (username,password_hash,role) VALUES ('zaharsahloul','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_DOCTOR');
INSERT INTO doctor (doctor_id, first_name, last_name, specialization, cost_per_hour)
                VALUES ((select user_id from users where role = 'ROLE_DOCTOR' and username = 'zaharsahloul'),'Dr. Zahar', 'Sahloul', 'Oncologist', 150);






INSERT INTO office (office_name, address_line_1, address_line_2, city, state, zip_code, phone_number, email, office_hours)
	VALUES ('The Haven Center for Mental Wellness', '789 Willowbrook Drive', '', 'Shaker Heights', 'OH', '44122', '216 207 9460', 'havencenter@gmail.com', '9:00am - 5:00pm EST');


INSERT INTO office (office_name, address_line_1, address_line_2, city, state, zip_code, phone_number, email, office_hours)
	VALUES ('Artemis Institute for Women', '100 Crescent Moon Drive', '', 'Olympia', 'WA', '98501', '360 201 5566', 'artemisinstitute@gmail.com', '9:00am - 5:00pm PST');


INSERT INTO office (office_name, address_line_1, address_line_2, city, state, zip_code, phone_number, email, office_hours)
	VALUES ('Visage', '500 Park Avenue', '', 'New York', 'NY', '10022', '212 917 3440', 'visagedermatology@gmail.com', '9:00am - 5:00pm EST');


INSERT INTO office (office_name, address_line_1, address_line_2, city, state, zip_code, phone_number, email, office_hours)
	VALUES ('Banyan Tree Cancer Care', '908 Chrysalis Way', '', 'Cleveland', 'OH', '44113', '216 867 5309', 'banyantreecancercare@gmail.com', '9:00am - 5:00pm EST');



UPDATE doctor
SET
    office_id = 1
WHERE
    doctor_id = 3;


UPDATE doctor
SET
    office_id = 1
WHERE
    doctor_id = 4;


UPDATE doctor
SET
    office_id = 2
WHERE
    doctor_id = 5;


UPDATE doctor
SET
    office_id = 2
WHERE
    doctor_id = 6;


UPDATE doctor
SET
    office_id = 3
WHERE
    doctor_id = 7;


UPDATE doctor
SET
    office_id = 3
WHERE
    doctor_id = 8;


UPDATE doctor
SET
    office_id = 4
WHERE
    doctor_id = 9;


UPDATE doctor
SET
    office_id = 4
WHERE
    doctor_id = 10;


UPDATE doctor
SET
    office_id = 4
WHERE
    doctor_id = 11;


INSERT INTO reviews ( office_id,  review )
VALUES ( 1, 'I highly recommend this hospital office for its exceptional service and attention to patient needs' )   ;

INSERT INTO reviews ( office_id,  review)
VALUES ( 1, 'Clean and organized environment, making my visit to the hospital office comfortable' )  RETURNING review_id ;

INSERT INTO reviews ( office_id,  review)
VALUES ( 1, 'The staff was friendly and professional, providing prompt assistance' )  RETURNING review_id ;

INSERT INTO reviews ( office_id,  review )
VALUES ( 2, 'Impressed by the professionalism of the doctors and nurses at this hospital office.' )  RETURNING review_id ;

INSERT INTO reviews ( office_id, review )
VALUES ( 2, 'They took the time to listen to my concerns and provided thorough explanations' )  RETURNING review_id ;

INSERT INTO reviews ( office_id,  review )
VALUES ( 3, 'I highly recommend this hospital office for its exceptional service and attention to patient needs' )  RETURNING review_id ;

INSERT INTO reviews ( office_id,  review )
VALUES ( 3, 'Every aspect of my experience, from scheduling to discharge, was handled with care and expertise' )  RETURNING review_id ;

INSERT INTO reviews ( office_id, review )
VALUES ( 3, 'The attention to detail and patient-centric approach made all the difference' )  RETURNING review_id ;






COMMIT TRANSACTION;
