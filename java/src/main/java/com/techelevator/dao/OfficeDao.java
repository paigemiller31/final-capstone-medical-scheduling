package com.techelevator.dao;

import com.techelevator.model.Office;

import java.util.List;

public interface OfficeDao {

    List<Office> getOfficeList();

    Office getOfficeByOfficeId(int officeId);

    Office updateOfficeByOfficeId(Office office);

}
