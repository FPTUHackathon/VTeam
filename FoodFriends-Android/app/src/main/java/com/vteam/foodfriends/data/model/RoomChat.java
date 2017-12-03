package com.vteam.foodfriends.data.model;

import java.util.List;

/**
 * Created by yukinohara on 12/3/17.
 */

public class RoomChat {
    private List<TextMessage> messages;
    private String boxId, userCreate;
    private boolean canJoin;

    public RoomChat(List<TextMessage> messages, String boxId, String userCreate, boolean canJoin) {
        this.messages = messages;
        this.boxId = boxId;
        this.userCreate = userCreate;
        this.canJoin = canJoin;
    }

    public RoomChat(String boxId, String userCreate, boolean canJoin) {
        this.boxId = boxId;
        this.userCreate = userCreate;
        this.canJoin = canJoin;
    }

    public List<TextMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<TextMessage> messages) {
        this.messages = messages;
    }

    public String getBoxId() {
        return boxId;
    }

    public void setBoxId(String boxId) {
        this.boxId = boxId;
    }

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public boolean isCanJoin() {
        return canJoin;
    }

    public void setCanJoin(boolean canJoin) {
        this.canJoin = canJoin;
    }
}
