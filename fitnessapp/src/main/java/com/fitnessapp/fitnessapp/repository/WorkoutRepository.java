package com.fitnessapp.fitnessapp.repository;

import com.fitnessapp.fitnessapp.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    List<Workout> findByUserId(Long id);
}
