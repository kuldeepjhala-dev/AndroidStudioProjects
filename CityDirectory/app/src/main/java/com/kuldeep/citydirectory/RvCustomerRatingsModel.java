package com.kuldeep.citydirectory;

public class RvCustomerRatingsModel {
    int img;
    String reviewer_name;
    String total_rating_no;
    int rating_bar;
    String review_period;
    String review;

    public RvCustomerRatingsModel(int img, String reviewer_name, String total_rating_no, int rating_bar, String review_period, String review) {
        this.img = img;
        this.reviewer_name = reviewer_name;
        this.total_rating_no = total_rating_no;
        this.rating_bar = rating_bar;
        this.review_period = review_period;
        this.review = review;
    }
}
