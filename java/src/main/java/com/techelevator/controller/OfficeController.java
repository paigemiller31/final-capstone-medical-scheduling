package com.techelevator.controller;
import com.techelevator.dao.OfficeDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Office;
import com.techelevator.service.OfficeService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@PreAuthorize("permitAll")
@RestController
@CrossOrigin
public class OfficeController {
    private OfficeDao officeDao;
    private OfficeService officeService;

    public OfficeController(OfficeDao officeDao, OfficeService officeService) {
        this.officeDao = officeDao;
        this.officeService = officeService;
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

    //TODO: REVIEW - RICH ADDED ALTERNATE END POINT SO THAT AN OFFICE HAS-A LIST<DOCTOR>
    @RequestMapping(path = "/offices-details", method = RequestMethod.GET)
    public List<Office> getOfficeDetailList() {
        List<Office> result = new ArrayList<>();
        try {
            result = officeService.getOfficeListDeep();
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }

    @RequestMapping(path="/offices/{officeId}", method = RequestMethod.GET)
    public Office getOfficeByOfficeIdController(@PathVariable int officeId) {

        Office office;

        try {
            office = officeDao.getOfficeByOfficeId(officeId);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (office == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Office not found");
        }
        return office;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path="/offices/{id}", method = RequestMethod.PUT)
    public Office updateOfficeByOfficeIdController(@Valid @RequestBody Office updatedOffice, @PathVariable int id) {

        updatedOffice.setOfficeId(id);

        try {
            return officeDao.updateOfficeByOfficeId(updatedOffice);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //TODO: Get Reviews ( List<Review> ? ) by officeID

}

