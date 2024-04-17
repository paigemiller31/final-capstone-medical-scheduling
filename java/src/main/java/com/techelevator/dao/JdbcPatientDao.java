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
    public void createPatient(Patient patient){

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

    @Override
    public Patient getPatientByUserId (int patientId) {
        Patient patient = new Patient( ) ;
       String sql =  " SELECT patient_id, first_name, last_name, phone_number, " +
               " email, address_line_1, address_line_2, city, state, zip_code " +
               " FROM patient where patient_id = ?  ; ";

       try {
           SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, patientId);
           if (rowSet.next()) {
               patient = mapRowToPatient(rowSet);
           }
       } catch (CannotGetJdbcConnectionException e) {
           throw new DaoException("Unable to connect to server or database", e);
       }
        return patient;
    }

    private Patient mapRowToPatient(SqlRowSet rs) {
        Patient patient = new Patient();
        patient.setPatientId(  rs.getInt("patient_id"));
        patient.setFirstName(  rs.getString("first_name"));
        patient.setLastName(  rs.getString("last_name"));
        patient.setPhoneNumber(  rs.getString("phone_number"));
        patient.setEmail(  rs.getString("email"));
        patient.setAddressLine1(  rs.getString("address_line_1"));
        patient.setAddressLine2(  rs.getString("address_line_2"));
        patient.setCity(  rs.getString("city"));
        patient.setState(  rs.getString("state"));
        patient.setZipCode(  rs.getString("zip_code"));


        return patient;
    }


}
