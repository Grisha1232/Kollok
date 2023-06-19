package com.example.kollok;

import java.util.List;

public interface MealService {
    void create(NewMeal user);
    List<NewMeal> readAll();
    NewMeal read(int id);
    boolean update(NewMeal user, int id);
    boolean delete(int id);
}
