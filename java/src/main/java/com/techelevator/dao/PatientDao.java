package com.techelevator.dao;

import com.techelevator.model.Patient;

public interface PatientDao {
    void createPatient(Patient patient);
    Patient getPatientByUserId(int userId);

    // update Account

}
