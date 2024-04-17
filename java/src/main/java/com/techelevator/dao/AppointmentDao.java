package com.techelevator.dao;

import com.techelevator.model.Appointment;

import java.util.List;

public interface AppointmentDao {

    List<Appointment> getAppointmentListByDoctorId(int doctorId);

    List<Appointment> getAppointmentByPatientId(int patientId);


//    List<Appointment> getAppointmentListByPatientId(int patientId);
//
//    List<Appointment> getAppointmentListByDoctorId(int doctorId);

//    public Appointment getAppointmentByPatientId(int patientId);
//
//    public Appointment getAppointmentByDoctorId(int doctorId);
//
//    public Appointment scheduleAppointmentByPatientId(Appointment patientId);

}
