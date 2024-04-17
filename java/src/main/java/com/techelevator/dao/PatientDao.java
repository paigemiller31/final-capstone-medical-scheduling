package com.techelevator.dao;

import com.techelevator.model.Patient;

public interface PatientDao {
    void createPatient(Patient patient);
    Patient getPatientByUserId(int patientId);

    // update Account

}
