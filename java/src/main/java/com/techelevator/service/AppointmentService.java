package com.techelevator.service;

import com.techelevator.dao.AppointmentDao;
import com.techelevator.dao.DoctorDao;
import com.techelevator.dao.OfficeDao;
import com.techelevator.dao.PatientDao;
import com.techelevator.model.Appointment;
import com.techelevator.model.Office;
import com.techelevator.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {



    private PatientDao patientDao;
    private AppointmentDao appointmentDao;

    public AppointmentService(PatientDao patientDao, AppointmentDao appointmentDao) {
        this.patientDao = patientDao;
        this.appointmentDao = appointmentDao;
    }

    public List<Appointment> getOfficeListDeep(){

        //  List<Appointment> officeReturn = new ArrayList<>();
        Patient p = new Patient();

        List<Appointment> appointmentReturn = appointmentDao.getAppointmentByPatientId(p.getPatientId());


        for(Appointment o : appointmentReturn){

            //  o.setOfficePatients( patientDao.getPatientByUserId(o.getPatientId() ) );

        }

        return appointmentReturn;

    }
}
