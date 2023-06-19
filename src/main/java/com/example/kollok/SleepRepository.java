package com.example.kollok;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SleepRepository extends JpaRepository<NewSleep, Integer> {
}
