package com.learn.tasks.domain.model;

import jakarta.persistence.*;

@Entity
public class Task {

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private boolean status = false;

//    public Task(Long id, String description, boolean status) {
//        this.id = id;
//        this.description = description;
//        this.status = status;
//    }

    public Task() {}

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isStatus() {
        return status;
    }
}
