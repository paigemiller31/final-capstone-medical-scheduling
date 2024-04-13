package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Appointment;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAppointmentDao implements AppointmentDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcAppointmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Appointment> getAppointmentList() {

        List<Appointment> appointmentList = new ArrayList<>();

        String sql = "SELECT appointment_id, patient_id, doctor_id, appointment_date, " +
                "appointment_time, duration, available, alert FROM appointment;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        try {
            while(results.next()) {
                Appointment appointment = mapRowToAppointment(results);
                appointmentList.add(appointment);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return appointmentList;
    }


    private Appointment mapRowToAppointment(SqlRowSet rs) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(rs.getInt("appointment_id"));
        appointment.setPatientId(rs.getInt("patient_id"));
        appointment.setDoctorId(rs.getInt("doctor_id"));
        appointment.setAppointmentDate(rs.getInt("appointment_date"));
        appointment.setAppointmentTime(rs.getInt("appointment_time"));
        appointment.setDuration(rs.getInt("duration"));
        appointment.setAvailable(rs.getBoolean("available"));
        appointment.setAlert(rs.getBoolean("alert"));
        return appointment;
    }

    @Override
    public Appointment getAppointmentByAppointmentId(int userId) {
        return null;
    }
}
