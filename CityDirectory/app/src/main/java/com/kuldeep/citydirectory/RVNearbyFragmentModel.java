package com.kuldeep.citydirectory;

public class RVNearbyFragmentModel {
    int img;
    String location_name;
    String total_rating_no;
    int rating_bar;
    String address;

    public RVNearbyFragmentModel(int img, String location_name, String total_rating_no, int rating_bar, String address) {
        this.img = img;
        this.location_name = location_name;
        this.total_rating_no = total_rating_no;
        this.rating_bar = rating_bar;
        this.address = address;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getTotal_rating_no() {
        return total_rating_no;
    }

    public void setTotal_rating_no(String total_rating_no) {
        this.total_rating_no = total_rating_no;
    }

    public int getRating_bar() {
        return rating_bar;
    }

    public void setRating_bar(int rating_bar) {
        this.rating_bar = rating_bar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
