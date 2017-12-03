package com.vteam.foodfriends.data.model;

import java.sql.Timestamp;

/**
 * Created by yukinohara on 12/3/17.
 */

public class FileMessage {
    private FileContent fileContent;
    private MessageFrom messageFrom;
    private Timestamp timestamp;
    private String type;

    public FileMessage(FileContent fileContent, MessageFrom messageFrom, Timestamp timestamp, String type) {
        this.fileContent = fileContent;
        this.messageFrom = messageFrom;
        this.timestamp = timestamp;
        this.type = type;
    }

    public FileContent getFileContent() {
        return fileContent;
    }

    public void setFileContent(FileContent fileContent) {
        this.fileContent = fileContent;
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
