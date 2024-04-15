package com.techelevator.service;

import com.techelevator.dao.DoctorDao;
import com.techelevator.dao.OfficeDao;
import com.techelevator.model.Office;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OfficeService {

    private OfficeDao officeDao;
    private DoctorDao doctorDao;

    public OfficeService(OfficeDao officeDao, DoctorDao doctorDao) {
        this.officeDao = officeDao;
        this.doctorDao = doctorDao;
    }

    public List<Office> getOfficeListDeep(){

        List<Office> officeReturn = new ArrayList<>();

        officeReturn = officeDao.getOfficeList();

        for(Office o : officeReturn){

            o.setOfficeDoctors( doctorDao.getDoctorsByOfficeId(o.getOfficeId()) );

        }

        return officeReturn;

    }
}
