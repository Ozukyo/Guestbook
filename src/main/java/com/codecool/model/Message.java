package com.codecool.model;

import java.sql.Timestamp;

public class Message {
    private int id;
    private String title;
    private String content;
    private String authorName;
    private Timestamp creationDate;

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

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public Message setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
        return this;
    }
}
