package com.codecool.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
    private int id;
    private String title;
    private String content;
    private String authorName;
    private String creationDate;
    private Timestamp date;
    

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

    public Message setCreationDate() {
        this.creationDate = "2077.05.02 09:23";
        return this;
    }

    public void convertStringToTimestamp() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSSSS");
            Date parsedDate = dateFormat.parse(this.creationDate + ".000000");
            this.setDate(new Timestamp(parsedDate.getTime()));

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Timestamp getConvertedDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
