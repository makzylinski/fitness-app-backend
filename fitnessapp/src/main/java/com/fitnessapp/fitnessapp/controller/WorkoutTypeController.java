package com.fitnessapp.fitnessapp.controller;

import com.fitnessapp.fitnessapp.dto.WorkoutTypeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workout-types")
public class WorkoutTypeController {
    @GetMapping
    public ResponseEntity<WorkoutTypeResponse> getWorkoutTypes() {
        WorkoutTypeResponse response = new WorkoutTypeResponse();
        return ResponseEntity.ok(response);
    }
}
