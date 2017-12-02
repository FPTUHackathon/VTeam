package com.vteam.foodfriends.data.model;

/**
 * Created by phuongbka on 12/2/17.
 */

public class Group {
    private String image, name, time, number;

    public Group(){};

    public Group(String image, String name, String time, String number) {
        this.image = image;
        this.name = name;
        this.time = time;
        this.number = number;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
