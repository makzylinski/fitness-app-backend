package com.fitnessapp.fitnessapp.controller;

import com.fitnessapp.fitnessapp.dto.WorkoutRequest;
import com.fitnessapp.fitnessapp.model.User;
import com.fitnessapp.fitnessapp.model.Workout;
import com.fitnessapp.fitnessapp.repository.UserRepository;
import com.fitnessapp.fitnessapp.repository.WorkoutRepository;
import com.fitnessapp.fitnessapp.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutsController {
    private static final Logger logger = LoggerFactory.getLogger(WorkoutsController.class);

    @Autowired
    private JwtService jwtService;

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addWorkout(@RequestBody WorkoutRequest workoutRequest, HttpServletRequest request) {
        logger.info("Received request to add workout: {}", workoutRequest);

        String token = jwtService.extractTokenFromCookie(request);
        if (token == null) {
            logger.warn("Unauthorized request: no token found");
            return ResponseEntity.status(401).body("Unauthorized");
        }

        String email = jwtService.extractEmailFromToken(token);
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> {
                    logger.error("User not found for email: {}", email);
                    return new RuntimeException("User not found");
                });

        Workout workout = new Workout(
                user.getId(),
                workoutRequest.getExerciseDetails().getName(),
                workoutRequest.getExerciseDetails().getDate(),
                workoutRequest.getExerciseDetails().getNote()
        );

        workoutRepository.save(workout);
        logger.info("Workout added successfully: {}", workout.getWorkoutName());
        return ResponseEntity.ok("Workout added successfully: " + workout.getWorkoutName());
    }
}