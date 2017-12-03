package com.vteam.foodfriends.data.model;

/**
 * Created by yukinohara on 12/2/17.
 */

public class Pair {
    private String uid, time;

    public Pair(String uid, String time) {
        this.uid = uid;
        this.time = time;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
