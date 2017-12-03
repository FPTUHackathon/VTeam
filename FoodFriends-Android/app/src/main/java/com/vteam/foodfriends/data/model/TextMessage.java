package com.vteam.foodfriends.data.model;

import java.sql.Timestamp;

/**
 * Created by phuongbka on 12/2/17.
 */

public class TextMessage<T> {
    private T content;
    private MessageFrom messageFrom;
    private long timestamp;
    private String type;

    public TextMessage(T content, MessageFrom messageFrom, String type) {
        this.content = content;
        this.messageFrom = messageFrom;
        this.type = type;
    }

    public TextMessage(T content, String type) {
        this.content = content;
        this.type = type;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public MessageFrom getMessageFrom() {
        return messageFrom;
    }

    public void setMessageFrom(MessageFrom messageFrom) {
        this.messageFrom = messageFrom;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
