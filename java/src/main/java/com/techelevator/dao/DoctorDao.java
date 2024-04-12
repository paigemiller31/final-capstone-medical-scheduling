package com.techelevator.dao;
import com.techelevator.model.Doctor;

import javax.print.Doc;
import java.util.List;

public interface DoctorDao {

    // getDoctorByOfficeId and possibly listOfDoctorsByOfficeId
    void createDoctor(Doctor doctor);
    List<Doctor> getDoctorsByOfficeId(int officeId);

}
