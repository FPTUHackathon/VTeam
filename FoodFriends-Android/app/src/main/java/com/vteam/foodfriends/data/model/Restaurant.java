package com.vteam.foodfriends.data.model;

import java.util.List;

/**
 * Created by phuongbka on 12/1/17.
 */

public class Restaurant {
    private String address, name, photoUrl, timeOpen, timeClose;
    private int rating, totalReview, discount;
    private double lat, lon;
    private List<String> gallery;
    private List<Cuisine> cuisines;
    private List<Comment> comments;

    public Restaurant(String address, String name, String photoUrl, String timeOpen, String timeClose, int rating, int totalReview, int discount, double lat, double lon, List<String> gallery, List<Cuisine> cuisines, List<Comment> comments) {
        this.address = address;
        this.name = name;
        this.photoUrl = photoUrl;
        this.timeOpen = timeOpen;
        this.timeClose = timeClose;
        this.rating = rating;
        this.totalReview = totalReview;
        this.discount = discount;
        this.lat = lat;
        this.lon = lon;
        this.gallery = gallery;
        this.cuisines = cuisines;
        this.comments = comments;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getTimeOpen() {
        return timeOpen;
    }

    public void setTimeOpen(String timeOpen) {
        this.timeOpen = timeOpen;
    }

    public String getTimeClose() {
        return timeClose;
    }

    public void setTimeClose(String timeClose) {
        this.timeClose = timeClose;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getTotalReview() {
        return totalReview;
    }

    public void setTotalReview(int totalReview) {
        this.totalReview = totalReview;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public List<String> getGallery() {
        return gallery;
    }

    public void setGallery(List<String> gallery) {
        this.gallery = gallery;
    }

    public List<Cuisine> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<Cuisine> cuisines) {
        this.cuisines = cuisines;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
