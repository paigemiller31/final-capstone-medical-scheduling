package com.techelevator.dao;
import com.techelevator.model.Doctor;

import javax.print.Doc;

public interface DoctorDao {

    public Doctor getDoctorByUserId(int userId);
    public void createDoctor(Doctor doctor);
}
