package com.codecool.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Message {
    private int id;
    private String title;
    private String content;
    private String authorName;
    private String creationDate;
    

    public int getId() {
        return id;
    }

    public Message setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Message setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Message setContent(String content) {
        this.content = content;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Message setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public Message setCurrentCreationDate() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(timestamp);
        this.creationDate = dateformat;
        return this;
    }

    public Message setCreationDateFromDB(String date) {
        this.creationDate = date;
        return this;
    }

}
