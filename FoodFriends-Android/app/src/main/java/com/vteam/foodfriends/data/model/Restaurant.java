package com.vteam.foodfriends.data.model;

import java.util.List;

/**
 * Created by phuongbka on 12/1/17.
 */

public class Restaurant {
    private String address, name, imagelink,timeavailable, star;
    private List<String> foods;

    public Restaurant(){};

    public Restaurant(String address, String name, String imagelink, String timeavailable, String star, List<String> foods) {
        this.address = address;
        this.name = name;
        this.imagelink = imagelink;
        this.timeavailable = timeavailable;
        this.star = star;
        this.foods = foods;
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

    public String getImagelink() {
        return imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink;
    }

    public String getTimeavailable() {
        return timeavailable;
    }

    public void setTimeavailable(String timeavailable) {
        this.timeavailable = timeavailable;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public List<String> getFoods() {
        return foods;
    }

    public void setFoods(List<String> foods) {
        this.foods = foods;
    }
}
