package com.codegym.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String uploader;
    private LocalDate dayCreated = LocalDate.now();

    @ManyToOne
    private Category category;

    private String content;

    public Blog() {
    }

    public Blog(int id, String title, String uploader, String content) {
        this.id = id;
        this.title = title;
        this.uploader = uploader;
        this.content = content;
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

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDayCreated() {
        return dayCreated;
    }

    public void setDayCreated(LocalDate dayCreated) {
        this.dayCreated = dayCreated;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}