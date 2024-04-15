package com.techelevator.dao;

import com.techelevator.model.Reviews;

import java.util.List;

public interface ReviewsDao {

    List<Reviews> getOfficeReviews(int officeId);

    void createReview(Reviews review);

}



