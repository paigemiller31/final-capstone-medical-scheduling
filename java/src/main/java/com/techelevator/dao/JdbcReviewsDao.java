package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Reviews;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReviewsDao implements ReviewsDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcReviewsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public  List<Reviews> getOfficeReviews(int officeId){

        List<Reviews> reviewsList = new ArrayList<>();

        String sql = " select review_id, office_id, stars, review, response from reviews where  office_id = ? ; ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);

        try {
            while (results.next()) {
                Reviews review = mapRowToReview (results);
                reviewsList.add(review);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return reviewsList;
    }

    @Override
    public   void createReview(Reviews review) {

        String sql =
                " INSERT INTO reviews (  office_id, review ) VALUES (  ?, ? )  RETURNING review_id ; " ;

        try {

            int review_id =   jdbcTemplate.queryForObject( sql ,
                    int.class,
                    review.getOfficeId(),
                    // review.getStars(),
                    review.getReview()
                  //  review.getResponse()

            );

            // patient.setPatientId(patientId); // Set the generated patientId to the newPatient object


        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

    }


    private Reviews mapRowToReview(SqlRowSet rs) {
        Reviews review = new Reviews();
        review.setReviewId(  rs.getInt("review_id"));
        review.setOfficeId(  rs.getInt("office_id"));
        review.setReview(rs.getString("review"));
       // review.setStars(  rs.getInt("stars"));
        //if (rs.getString("review") != null) {

        //}
        //if (rs.getString("response") != null) {
       //     review.setResponse(rs.getString("response"));
        //}
        return review;
    }





}
