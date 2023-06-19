package com.example.kollok;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "user_sleep")
public class NewSleep {
    @Id
    @Column
    private Integer id;
    @Column
    private Integer seconds;
    @Column
    private Integer user_id;

    public NewSleep(Integer seconds, Integer user_id) {
        this.seconds = seconds;
        this.user_id = user_id;
    }

    public NewSleep() {

    }

    public Integer getId() {
        return id;
    }

    public Integer getSeconds() {
        return seconds;
    }
    public Integer getUser_id() {
        return user_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
