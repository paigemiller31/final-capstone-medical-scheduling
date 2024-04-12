package com.techelevator.controller;
import com.techelevator.dao.OfficeDao;
import com.techelevator.model.Office;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@PreAuthorize("permitAll")
@RestController
@CrossOrigin
public class OfficeController {
    private OfficeDao officeDao;

    public OfficeController(OfficeDao officeDao) {
        this.officeDao = officeDao;
    }


    @RequestMapping(path = "/offices", method = RequestMethod.GET)
    public List<Office> getOfficeListController() {
        List<Office> result = new ArrayList<>();
        try {
            result = officeDao.getOfficeList();
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }
}

