package com.example.kollok;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<NewMeal, Integer> {
}
