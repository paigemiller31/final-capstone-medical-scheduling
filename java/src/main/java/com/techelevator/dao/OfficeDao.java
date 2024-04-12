package com.techelevator.dao;

import com.techelevator.model.Office;

import java.util.List;

public interface OfficeDao {

    public List<Office> getOfficeList();

    public Office getOfficeByOfficeId(int userId);

}
