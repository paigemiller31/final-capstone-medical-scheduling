package com.techelevator.controller;

import com.techelevator.dao.ReviewsDao;
import com.techelevator.model.Reviews;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@PreAuthorize("permitAll")
@RestController
@CrossOrigin
public class ReviewsController {

    private ReviewsDao reviewsDao;
    public ReviewsController(ReviewsDao reviewsDao) {
        this.reviewsDao = reviewsDao;
    }

    @RequestMapping(path = "/reviews/{officeId}", method = RequestMethod.GET)
    public List<Reviews> getOfficeReviewsController(@PathVariable int officeId) {
        List<Reviews> result = new ArrayList<>();
        try {
            result = reviewsDao.getOfficeReviews( officeId );
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public void createReviewController(@RequestBody Reviews newReview) {
        try {
            reviewsDao.createReview( newReview);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR , "review API failed.");
        }
    }

}
