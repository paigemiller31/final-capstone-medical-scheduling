//package com.techelevator.controller;
//import com.techelevator.dao.DoctorDao;
//import com.techelevator.exception.DaoException;
//import com.techelevator.model.*;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//
//import com.techelevator.dao.UserDao;
//import com.techelevator.security.jwt.JWTFilter;
//import com.techelevator.security.jwt.TokenProvider;
//
//@PreAuthorize("permitAll")
//@RestController
//@CrossOrigin
//public class DoctorController {
//    private DoctorDao doctorDao;
//    public DoctorController(DoctorDao doctorDao) {
//        this.doctorDao = doctorDao;
//    }
//
//
//    @ResponseStatus(HttpStatus.CREATED)
//    @RequestMapping(path = "/doctor", method = RequestMethod.POST)
//    public void createTransfer(@RequestBody Doctor newdoctor) {
//        try {
//            doctorDao.createDoctor( doctorDao);
//        } catch (Exception ex) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR , "doctor API test failed.");
//        }
//    }
//}
