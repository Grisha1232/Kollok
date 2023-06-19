package com.example.kollok;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<NewActivity, Integer> {
}
