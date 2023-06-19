package com.example.kollok;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "user_meals")
public class NewMeal {
    @Id
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer gramms;
    @Column
    private Integer kalories;
    @Column
    private Integer user_id;

    public NewMeal(String name, Integer gramms, Integer kalories, Integer user_id) {
        this.name = name;
        this.gramms = gramms;
        this.kalories = kalories;
    }

    public NewMeal() {

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getGramms() {
        return gramms;
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
