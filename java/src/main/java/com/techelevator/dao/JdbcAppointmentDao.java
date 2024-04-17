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


//    @Override
//    public List<Appointment> getAppointmentListByPatientId(int patientId) {
//
//        List<Appointment> appointmentList = new ArrayList<>();
//
//        String sql = "SELECT appointment_id, patient_id, doctor_id, appointment_date, " +
//                "appointment_time, duration, available, alert FROM appointment;";
//
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
//
//        try {
//            while(results.next()) {
//                Appointment appointment = mapRowToAppointment(results);
//                appointmentList.add(appointment);
//            }
//        } catch (CannotGetJdbcConnectionException e) {
//            throw new DaoException("Unable to connect to server or database", e);
//        }
//
//        return appointmentList;
//    }


    // this is for doctors to see appointments
    @Override
    public List<Appointment> getAppointmentListByDoctorId(int doctorId) {

        List<Appointment> appointments = new ArrayList<>();

        String sql = "SELECT p.patient_id, p.first_name, p.last_name, p.phone_number, p.email, " +
                        "p.address_line_1, p.address_line_2, p.city, p.state, p.zip_code, " +
                        "a.appointment_id, a.doctor_id, a.appointment_date, a.appointment_time, " +
                        "a.duration, a.available, a.alert " +
                        "FROM patient AS p " +
                        "INNER JOIN appointment AS a ON a.patient_id = p.patient_id " +
                        "WHERE a.doctor_id = ? " +
                        "ORDER BY a.appointment_date DESC;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
            while (results.next()) {
                Appointment appointment = mapRowToAppointment(results);
                appointments.add(appointment);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return appointments;
    }

    // this is for patients to see their appointments
    @Override
    public List<Appointment> getAppointmentByPatientId(int patientId) {

        List<Appointment> appointments = new ArrayList<>();

        String sql = "SELECT d.doctor_id, d.office_id, d.first_name, d.last_name, d.specialization, " +
                        "d.cost_per_hour, a.appointment_id, a.patient_id, a.appointment_date, " +
                        "a.appointment_time, a.duration, a.available, a.alert " +
                        "FROM doctor AS d " +
                        "INNER JOIN appointment AS a ON a.doctor_id = d.doctor_id " +
                        "WHERE a.patient_id = ? " +
                        "ORDER BY a.appointment_date DESC;";

//                "SELECT appointment_id, patient_id, doctor_id, appointment_date, " +
//                "appointment_time, duration, available, alert FROM appointment;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
            while (results.next()) {
                Appointment appointment = mapRowToAppointment(results);
                appointments.add(appointment);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return appointments;
    }

    @Override
    public void createAppointment(Appointment appointment){
        String sql =
                " INSERT INTO appointment ( patient_id, doctor_id, appointment_date, appointment_time, duration, available, alert ) " +
                        " VALUES (  ?, ?, ?, ?, ?, 'f', 't' )  RETURNING appointment_id ; " ;

        try {

            int newPatientId =   jdbcTemplate.queryForObject( sql ,
                    int.class,
                    appointment.getPatientId(),
                    appointment.getDoctorId(),
                    appointment.getAppointmentDate(),
                    appointment.getAppointmentTime() ,
                    appointment.getDuration()

            );

            // patient.setPatientId(patientId); // Set the generated patientId to the newPatient object


        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }


    }







//    @Override
//    public Appointment getAppointmentByDoctorId(int doctorId) {
//
//        Appointment appointment = null;
//
//        String sql = "SELECT appointment_id, patient_id, doctor_id, appointment_date, " +
//                "appointment_time, duration, available, alert FROM appointment;";
//
//        try {
//            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
//            if (results.next()) {
//                appointment = mapRowToAppointment(results);
//            }
//        } catch (CannotGetJdbcConnectionException e) {
//            throw new DaoException("Unable to connect to server or database", e);
//        }
//        return appointment;
//    }

//    public Appointment scheduleAppointmentByPatientId(Appointment patientId) {
//        Appointment appointment = null;
//
//        String sql = "INSERT INTO appointment (appointment_id, patient_id, doctor_id, appointment_date," +
//                " appointment_time, duration, available, alert) returning appointment_id";
//        try {
//            int newAppointment = jdbcTemplate.queryForObject(sql, int.class, patientId.getAppointmentId(),patientId.getPatientId(), patientId.getDoctorId(),
//                    patientId.getAppointmentDate(), patientId.getAppointmentTime(), patientId.getDuration());
//            appointment = getAppointmentByPatientId(newAppointment);
//        } catch (CannotGetJdbcConnectionException e) {
//            throw new DaoException("Unable to connect to server or database", e);
//        } catch (DataIntegrityViolationException e) {
//            throw new DaoException("Data integrity violation", e);
//        }
//        return appointment;
//    }

    private Appointment mapRowToAppointment(SqlRowSet rs) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(rs.getInt("appointment_id"));
        appointment.setPatientId(rs.getInt("patient_id"));
        appointment.setDoctorId(rs.getInt("doctor_id"));
        appointment.setAppointmentDate(rs.getDate("appointment_date").toLocalDate());
        appointment.setAppointmentTime(rs.getTime("appointment_time").toLocalTime());
        appointment.setDuration(rs.getInt("duration"));
        appointment.setAvailable(rs.getBoolean("available"));
        appointment.setAlert(rs.getBoolean("alert"));
        return appointment;
    }


}
