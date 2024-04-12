package com.techelevator.dao;
import com.techelevator.model.Doctor;

import javax.print.Doc;

public interface DoctorDao {

    // getDoctorByOfficeId and possibly listOfDoctorsByOfficeId
    public Doctor getDoctorByUserId(int userId);
    public void createDoctor(Doctor doctor);
}
