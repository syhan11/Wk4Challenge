package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.lang.NonNull;
import javax.validation.constraints.Size;

@Entity
public class Message {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Size(min=3)
    private String title;

    @NonNull
    @Size(min=10)
    private String content;

    @NonNull
    @Size(min=4)
    private String postedDate;

    @NonNull
    @Size(min=3)
    private String postedBy;

    public Message() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
