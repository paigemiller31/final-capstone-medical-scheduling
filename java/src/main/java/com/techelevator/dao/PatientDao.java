package com.techelevator.dao;

import com.techelevator.model.Patient;

public interface PatientDao {

    public Patient getPatientByUserId(int userId);

    // update Account
    public void createPatient(Patient patient);
}
