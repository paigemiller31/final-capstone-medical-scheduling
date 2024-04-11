package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.model.Patient;
import org.springframework.stereotype.Component;


@Component
public class JdbcPatientDao implements PatientDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcPatientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Patient getPatientByUserId (int userId) {
        Patient patient = new Patient( ) ;
//        String sql =  " SELECT account_id, user_id, balance FROM account where  user_id = ?  ; ";
//
//        try {
//            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
//            if (rowSet.next()) {
//                patient = mapRowToAccount(rowSet);
//            }
//        } catch (CannotGetJdbcConnectionException e) {
//            throw new DaoException("Unable to connect to server or database", e);
//        }
        return patient;
    }

    @Override
    public void createPatient(Patient patient){

        Patient p =  null;

        String sql =
                " INSERT INTO patient ( patient_id, first_name, last_name, phone_number, email, address_line_1, address_line_2, city, state, zip_code) " +
                " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )  RETURNING patient_id ; " ;

        try {

            int newPatientId =   jdbcTemplate.queryForObject( sql ,
                    int.class,
                    patient.getPatientId(),
                    patient.getFirstName(),
                    patient.getLastName(),
                    patient.getPhoneNumber(),
                    patient.getEmail(),
                    patient.getAddressLine1(),
                    patient.getAddressLine2(),
                    patient.getCity(),
                    patient.getState(),
                    patient.getZipCode()
                    );

           // patient.setPatientId(patientId); // Set the generated patientId to the newPatient object


        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

    }


    private Patient mapRowToPatient(SqlRowSet rs) {
        Patient patient = new Patient();
        patient.setPatientId(  rs.getInt("patient_id"));
        return patient;
    }


}
