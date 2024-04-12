package com.techelevator.dao;
import com.techelevator.model.Doctor;

import javax.print.Doc;
import java.util.List;

public interface DoctorDao {

    // getDoctorByOfficeId and possibly listOfDoctorsByOfficeId
    public List<Doctor> getDoctorsByUserId(int officeId);
    public void createDoctor(Doctor doctor);
}
