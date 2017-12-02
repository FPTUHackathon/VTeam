package com.vteam.foodfriends.data.model;

/**
 * Created by H2PhySicS on 12/1/2017.
 */

public class Comment {
    private String title;
    private String author;
    private String time;
    private String content;
    private int rating;

    public Comment(String title, String author, String time, String content, int rating) {
        this.title = title;
        this.author = author;
        this.time = time;
        this.content = content;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", time='" + time + '\'' +
                ", content='" + content + '\'' +
                ", rating=" + rating +
                '}';
    }
}
