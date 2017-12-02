package com.vteam.foodfriends.data.model;

import java.sql.Time;

/**
 * Created by phuongbka on 12/2/17.
 */

public class Messenger {
    private String name, message, time;

    public Messenger(){};

    public Messenger(String name, String message, String time) {
        this.name = name;
        this.message = message;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime(){return time;}

    public void setTime(String time){this.time = time;}
}
