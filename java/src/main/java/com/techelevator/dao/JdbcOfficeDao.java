package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.model.Office;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcOfficeDao implements OfficeDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcOfficeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Office> getOfficeList() {

        List<Office> officeList = new ArrayList<>();

        String sql = "SELECT office_id, office_name, address_line_1, address_line_2, " +
                "city, state, zip_code, phone_number, email, office_hours FROM office;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        try {
            while (results.next()) {
                Office office = mapRowToOffice(results);
                officeList.add(office);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return officeList;
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




    private Office mapRowToOffice(SqlRowSet rs) {
        Office office = new Office();
        office.setOfficeId(  rs.getInt("office_id"));
        office.setOfficeName(rs.getString("office_name"));
        office.setAddressLine1(rs.getString("address_line_1"));
        office.setAddressLine2(rs.getString("address_line_2"));
        office.setCity(rs.getString("city"));
        office.setState(rs.getString("state"));
        office.setZipCode(rs.getString("zip_code"));
        office.setPhoneNumber(rs.getString("phone_number"));
        office.setEmail(rs.getString("email"));
        office.setOfficeHours(rs.getString("office_hours"));
        return office;
    }




}
