package com.vteam.foodfriends.data.model;

/**
 * Created by yukinohara on 12/2/17.
 */

public class Pair {
    private String time;
    private User user;

    public Pair(String time, User user) {
        this.time = time;
        this.user = user;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
