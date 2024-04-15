package com.techelevator.model;

public class Reviews {

    private int reviewId;
    private int officeId;
    private int stars;
    private String review;
    private String response ;


    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Reviews(int reviewId, int officeId, int stars, String review, String response) {
        this.reviewId = reviewId;
        this.officeId = officeId;
        this.stars = stars;
        this.review = review;
        this.response = response;
    }

    public Reviews(int officeId, String review) {

        this.officeId = officeId;
        this.review = review;
    }
    public Reviews( ){

    }

}
