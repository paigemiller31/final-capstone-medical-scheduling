package com.techelevator.dao;

import com.techelevator.model.Appointment;
import com.techelevator.model.Patient;
import com.techelevator.model.ScheduleBlock;

import java.sql.Date;
import java.util.List;

public interface AppointmentDao {

    List<Appointment> getAppointmentListByDoctorId(int doctorId);

    List<Appointment> getAppointmentByPatientId(int patientId);


    void createAppointment(Appointment appointment);

    List<ScheduleBlock> getAppointmentsForDate(String apptDate);


//    List<Appointment> getAppointmentListByPatientId(int patientId);
//
//    List<Appointment> getAppointmentListByDoctorId(int doctorId);

//    public Appointment getAppointmentByPatientId(int patientId);
//
//    public Appointment getAppointmentByDoctorId(int doctorId);
//
//    public Appointment scheduleAppointmentByPatientId(Appointment patientId);

}
