package com.vteam.foodfriends.data.model;

import java.util.List;

/**
 * Created by phuongbka on 11/29/17.
 */

public class User {
    private String email, password, name, phone, dob, avatar;
    private boolean isMale;
    private List<String> follows;

    public User(){
    }

    public User(String email, String password, String name, String phone) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    public User(String email, String password, String name, String phone, String dob, String avatar, boolean isMale, List<String> follows) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        this.avatar = avatar;
        this.isMale = isMale;
        this.follows = follows;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public List<String> getFollows() {
        return follows;
    }

    public void setFollows(List<String> follows) {
        this.follows = follows;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
