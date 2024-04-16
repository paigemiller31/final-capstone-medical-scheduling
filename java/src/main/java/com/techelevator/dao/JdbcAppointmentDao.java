package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Appointment;
import org.springframework.dao.DataIntegrityViolationException;
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
    public List<Appointment> getAppointmentListByPatientId(int patientId) {

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

    @Override
    public List<Appointment> getAppointmentListByDoctorId(int doctorId) {

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
    @Override
    public Appointment getAppointmentByPatientId(int patientId) {

        Appointment appointment = null;

        String sql = "SELECT appointment_id, patient_id, doctor_id, appointment_date, " +
                "appointment_time, duration, available, alert FROM appointment;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
            if (results.next()) {
                appointment = mapRowToAppointment(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return appointment;
    }

    @Override
    public Appointment getAppointmentByDoctorId(int doctorId) {

        Appointment appointment = null;

        String sql = "SELECT appointment_id, patient_id, doctor_id, appointment_date, " +
                "appointment_time, duration, available, alert FROM appointment;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
            if (results.next()) {
                appointment = mapRowToAppointment(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return appointment;
    }

    public Appointment scheduleAppointmentByPatientId(Appointment patientId) {
        Appointment appointment = null;

        String sql = "INSERT INTO appointment (appointment_id, patient_id, doctor_id, appointment_date," +
                " appointment_time, duration, available, alert) returning appointment_id";
        try {
            int newAppointment = jdbcTemplate.queryForObject(sql, int.class, patientId.getAppointmentId(),patientId.getPatientId(), patientId.getDoctorId(),
                    patientId.getAppointmentDate(), patientId.getAppointmentTime(), patientId.getDuration());
            appointment = getAppointmentByPatientId(newAppointment);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return appointment;
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


}
