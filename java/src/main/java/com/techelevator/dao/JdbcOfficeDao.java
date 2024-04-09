package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.model.Office;
import org.springframework.stereotype.Component;
@Component
public class JdbcOfficeDao implements OfficeDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcOfficeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Office getOfficeByOfficeId(int userId) {
        Office office = new Office( ) ;
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
        return office;
    }

    @Override
    public void createOffice(Office office) {

        String sql =
                " INSERT INTO office ( address_line_1, address_line_2, city, state, zip_code, phone_number, email, office_hours, cost_per_hour ) " +
                        " VALUES (  ?, ?, ?, ?, ?, ?, ?, ?, ? )  RETURNING office_id ; " ;

        try {

            int newOfficeId =   jdbcTemplate.queryForObject( sql ,

                    int.class,
//                    office.getDoctorId(),
//                    office.getPatientId(),
                    office.getAddressLine1(),
                    office.getAddressLine2(),
                    office.getCity(),
                    office.getState(),
                    office.getZipCode(),
                    office.getPhoneNumber(),
                    office.getEmail(),
                    office.getOfficeHours(),
                    office.getCostPerHour()

            );

            // patient.setPatientId(patientId); // Set the generated patientId to the newPatient object


        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

    }


    private Office mapRowToOffice(SqlRowSet rs) {
        Office office = new Office();
        office.setOfficeId(  rs.getInt("office_id"));

        return office;
    }




}
