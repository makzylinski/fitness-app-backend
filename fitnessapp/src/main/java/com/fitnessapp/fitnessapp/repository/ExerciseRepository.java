package com.fitnessapp.fitnessapp.repository;

import com.fitnessapp.fitnessapp.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {}

