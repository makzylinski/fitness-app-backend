package com.fitnessapp.fitnessapp.controller;

import com.fitnessapp.fitnessapp.dto.WorkoutRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class WorkoutsController {
    @PostMapping("/workouts")
    public ResponseEntity<String> addWorkout(@RequestBody WorkoutRequest workoutRequest) {

        return ResponseEntity.ok("Workout added successfully: " + workoutRequest.getName());
    }
}
