package com.techelevator.dao;

import com.techelevator.model.Appointment;

import java.util.List;

public interface AppointmentDao {
    List<Appointment> getAppointmentList();

    public Appointment getAppointmentByAppointmentId(int userId);

}
