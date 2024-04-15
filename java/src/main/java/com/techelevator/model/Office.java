package com.techelevator.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Office {
    private int officeId;
    private String officeName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String email;
    private String officeHours;
    private List<Doctor> officeDoctors = new ArrayList<>();

    public Office() {

    }

    public Office(int officeId, String officeName,
                  String addressLine1, String addressLine2,
                  String city, String state,
                  String zipCode, String phoneNumber, String email,
                  String officeHours) {
        this.officeId = officeId;
        this.officeName = officeName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.officeHours = officeHours;

    }



    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public List<Doctor> getOfficeDoctors() {
        return officeDoctors;
    }

    public void setOfficeDoctors(List<Doctor> officeDoctors) {
        this.officeDoctors = officeDoctors;
    }
}
