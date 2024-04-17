package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleBlock {

    private int officeId;
    private int doctorId;
    private LocalTime timeBlock;
    private int appointmentId;
    private int patientId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private int duration;
    private boolean available;
    private boolean alert;

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public LocalTime getTimeBlock() {
        return timeBlock;
    }

    public void setTimeBlock(LocalTime timeBlock) {
        this.timeBlock = timeBlock;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAlert() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
    }

    public ScheduleBlock(){

    }

    public ScheduleBlock(int officeId, int doctorId, LocalTime timeBlock, int appointmentId, int patientId, LocalDate appointmentDate, LocalTime appointmentTime, int duration, boolean available, boolean alert) {
        this.officeId = officeId;
        this.doctorId = doctorId;
        this.timeBlock = timeBlock;
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.duration = duration;
        this.available = available;
        this.alert = alert;
    }
}
