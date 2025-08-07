package com.fitnessapp.fitnessapp.controller;

import com.fitnessapp.fitnessapp.dto.WorkoutTypeResponse;
import com.fitnessapp.fitnessapp.model.WorkoutType;
import com.fitnessapp.fitnessapp.repository.WorkoutTypeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/workout-types")
public class WorkoutTypeController {
    private final WorkoutTypeRepository workoutTypeRepository;

    public WorkoutTypeController(WorkoutTypeRepository workoutTypeRepository) {
        this.workoutTypeRepository = workoutTypeRepository;
    }

    @GetMapping
    public ResponseEntity<List<WorkoutType>> getWorkoutTypes() {
        WorkoutTypeResponse response = new WorkoutTypeResponse();
        List<WorkoutType> workoutTypes = workoutTypeRepository.findAll();
        return ResponseEntity.ok(workoutTypes);
    }
}
