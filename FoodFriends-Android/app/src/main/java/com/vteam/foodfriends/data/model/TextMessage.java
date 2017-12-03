package com.vteam.foodfriends.data.model;

import java.sql.Timestamp;

/**
 * Created by phuongbka on 12/2/17.
 */

public class TextMessage {
    private TextContent textContent;
    private MessageFrom messageFrom;
    private Timestamp timestamp;
    private String type;

    public TextMessage(TextContent textContent, MessageFrom messageFrom, Timestamp timestamp, String type) {
        this.textContent = textContent;
        this.messageFrom = messageFrom;
        this.timestamp = timestamp;
        this.type = type;
    }

    public TextContent getTextContent() {
        return textContent;
    }

    public void setTextContent(TextContent textContent) {
        this.textContent = textContent;
    }

    public MessageFrom getMessageFrom() {
        return messageFrom;
    }

    public void setMessageFrom(MessageFrom messageFrom) {
        this.messageFrom = messageFrom;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
