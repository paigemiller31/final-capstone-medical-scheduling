BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');

INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (username,password_hash,role) VALUES ('marysmith','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_DOCTOR');
INSERT INTO doctor (doctor_id, first_name, last_name, specialization, cost_per_hour)
                VALUES ((select user_id from users where role = 'ROLE_DOCTOR' and username = 'marysmith'),'Mary', 'Smith', 'Optometrist', 65);


INSERT INTO users (username,password_hash,role) VALUES ('josephfranz','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_DOCTOR');
INSERT INTO doctor (doctor_id, first_name, last_name, specialization, cost_per_hour)
                VALUES ((select user_id from users where role = 'ROLE_DOCTOR' and username = 'josephfranz'),'Joseph', 'Franz', 'Cardiologist', 80);

COMMIT TRANSACTION;
