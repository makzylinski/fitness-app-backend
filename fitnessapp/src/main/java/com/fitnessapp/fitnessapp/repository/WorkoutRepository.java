package com.fitnessapp.fitnessapp.repository;

import com.fitnessapp.fitnessapp.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    
}
