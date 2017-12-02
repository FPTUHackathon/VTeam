package com.vteam.foodfriends.data.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by phuongbka on 12/1/17.
 */

public class Restaurant implements Serializable{
    private String id, address, name, photoUrl, timeOpen, timeClose;
    private int totalReview;
    private long rating;
    private long[] discounts;
    private double lat, lon;
    private List<String> gallery;
    private List<Cuisine> cuisines;
    private List<Map<String, Object>> comments;

    public Restaurant(String id, String address, String name, String photoUrl, String timeOpen, String timeClose, int totalReview, long rating, long[] discounts, double lat, double lon, List<Map<String, Object>> comments) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.photoUrl = photoUrl;
        this.timeOpen = timeOpen;
        this.timeClose = timeClose;
        this.totalReview = totalReview;
        this.rating = rating;
        this.discounts = discounts;
        this.lat = lat;
        this.lon = lon;
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public int getTotalReview() {
        return totalReview;
    }

    public void setTotalReview(int totalReview) {
        this.totalReview = totalReview;
    }

    public long[] getDiscounts() {
        return discounts;
    }

    public void setDiscounts(long[] discounts) {
        this.discounts = discounts;
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

    public List<Map<String, Object>> getComments() {
        return comments;
    }

    public void setComments(List<Map<String, Object>> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", timeOpen='" + timeOpen + '\'' +
                ", timeClose='" + timeClose + '\'' +
                ", rating=" + rating +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
