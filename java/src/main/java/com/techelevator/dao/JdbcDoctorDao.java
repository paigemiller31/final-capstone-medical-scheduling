package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Office;
import com.techelevator.model.Patient;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.model.Doctor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDoctorDao implements DoctorDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcDoctorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void createDoctor(Doctor doctor){

        String sql =
                " INSERT INTO doctor (doctor_id, first_name, last_name, specialization, cost_per_hour) " +
                        " VALUES ( ?, ?, ?, ?, ? )  RETURNING doctor_id ; " ;

        try {

            int newDoctorId =   jdbcTemplate.queryForObject( sql,
                    int.class,
                    doctor.getDoctorId(),
                    doctor.getFirstName(),
                    doctor.getLastName(),
                    doctor.getSpecialization(),
                    doctor.getCostPerHour()
            );

            // doctor.setDoctorId(doctorId); // Set the generated doctorId to the newDoctor object


        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

    }

    @Override
    public List<Doctor> getDoctorsByOfficeId(int officeId){

        List<Doctor> doctorList = new ArrayList<>();
        String sql =  "  SELECT office_id, doctor_id, first_name, last_name, specialization, cost_per_hour " +
                " FROM public.doctor where office_id = ? ;" ;

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);

        try {
            while (results.next()) {
                Doctor doctor = mapRowToDoctor(results);
                doctorList.add(doctor);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return doctorList;
    }


    @Override
    public Doctor getDoctorsByDoctorId(int doctorId){

        Doctor doctor = new Doctor();
        String sql =  "  SELECT office_id, doctor_id, first_name, last_name, specialization, cost_per_hour " +
                " FROM public.doctor where doctor_id = ? ;" ;

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);

        try {
            if (results.next()) {
                 doctor = mapRowToDoctor(results);

            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return doctor;
    }

    private Doctor mapRowToDoctor(SqlRowSet rs) {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(  rs.getInt("doctor_id"));
        doctor.setOfficeId(  rs.getInt("office_id"));
        doctor.setFirstName(  rs.getString("first_name"));
        doctor.setLastName(  rs.getString("last_name"));
        doctor.setSpecialization(  rs.getString("specialization"));
        doctor.setCostPerHour(  rs.getInt("cost_per_hour"));
        return doctor;
    }
}
