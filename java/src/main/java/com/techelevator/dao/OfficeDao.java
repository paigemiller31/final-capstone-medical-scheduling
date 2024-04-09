package com.techelevator.dao;

import com.techelevator.model.Office;

public interface OfficeDao {

    public Office getOfficeByOfficeId(int userId);

    public void createOffice(Office office);

}
