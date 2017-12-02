package com.vteam.foodfriends.data.model;

/**
 * Created by phuongbka on 12/1/17.
 */

public class Partner {
    private String image, name, age, time, distance;

    public Partner(){};

    public Partner(String image, String name, String age, String time, String distance) {
        this.image = image;
        this.name = name;
        this.age = age;
        this.time = time;
        this.distance = distance;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
