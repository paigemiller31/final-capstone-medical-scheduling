package com.techelevator.model;

public class Doctor {

    private int doctorId;
    private int officeId;
    private String firstName;
    private String lastName;
    private String specialization;
    private int costPerHour;

    public Doctor() {

    }

    public Doctor(int doctorId, int officeId, String firstName, String lastName, String specialization, int costPerHour) {

        this.doctorId = doctorId;
        this.officeId = officeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.costPerHour = costPerHour;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(int costPerHour) {
        this.costPerHour = costPerHour;
    }
}
