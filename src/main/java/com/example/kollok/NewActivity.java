package com.example.kollok;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "user_activity")
public class NewActivity {

    @Id
    @Column
    private Integer id;
    @Column
    private String activity_kind;
    @Column
    private Integer seconds;
    @Column
    private Integer kalories;
    @Column
    private Integer user_id;

    public NewActivity(String activity_kind, Integer seconds, Integer kalories, Integer user_id) {
        this.activity_kind = activity_kind;
        this.seconds = seconds;
        this.kalories = kalories;
        this.user_id = user_id;
    }

    public NewActivity() {

    }

    public Integer getId() {
        return id;
    }

    public String getActivity_kind() {
        return activity_kind;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public Integer getKalories() {
        return kalories;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
