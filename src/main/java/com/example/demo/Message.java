package com.example.demo;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Message {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    @NonNull
    @Size(min=3, max=15)
    private String title;

    @NonNull
    @Size(min=3, max=300)
    private String content;

    @NonNull
    @Size(min=6, max=6)
    private String postedDate;

    @NonNull
    @Size(min=3, max=30)
    private String postedBy;

    public Message() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }
}
