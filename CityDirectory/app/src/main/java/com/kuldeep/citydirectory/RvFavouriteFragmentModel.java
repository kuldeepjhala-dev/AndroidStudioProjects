package com.kuldeep.citydirectory;

public class RvFavouriteFragmentModel {
    int img;
    String location_name;
    String total_rating_no;
    int rating_bar;
    String address;

    public RvFavouriteFragmentModel(int img, String location_name, String total_rating_no, int rating_bar, String address) {
        this.img = img;
        this.location_name = location_name;
        this.total_rating_no = total_rating_no;
        this.rating_bar = rating_bar;
        this.address = address;
    }
}
