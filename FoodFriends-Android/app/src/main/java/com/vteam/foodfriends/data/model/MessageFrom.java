package com.vteam.foodfriends.data.model;

/**
 * Created by yukinohara on 12/3/17.
 */

public class MessageFrom {
    private String avatar, id, name;

    public MessageFrom(String avatar, String id, String name) {
        this.avatar = avatar;
        this.id = id;
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
