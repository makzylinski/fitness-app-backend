package com.fitnessapp.fitnessapp.controller;

import com.fitnessapp.fitnessapp.dto.WorkoutRequest;
import com.fitnessapp.fitnessapp.model.User;
import com.fitnessapp.fitnessapp.model.Workout;
import com.fitnessapp.fitnessapp.repository.UserRepository;
import com.fitnessapp.fitnessapp.repository.WorkoutRepository;
import com.fitnessapp.fitnessapp.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutsController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private WorkoutRepository workoutRepository;

    @PostMapping("/workouts")
    public ResponseEntity<String> addWorkout(@RequestBody WorkoutRequest workoutRequest, HttpServletRequest request) {
        String token = jwtService.extractTokenFromCookie(request);
        if (token == null) {
            return ResponseEntity.status(401).body("Unauthorized");
        }

        String email = jwtService.extractEmailFromToken(token);
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Workout workout = new Workout(user.getId(), workoutRequest.getWorkoutName(), workoutRequest.getDate(), workoutRequest.getNote());


        //{
        //    "exerciseDetails": {
        //        "name": "Upper body",
        //        "date": "2025-09-17",
        //        "notes": "test"
        //    },
        //    "exercises": [
        //        {
        //            "exercise": {
        //                "id": 4,
        //                "typeName": "Walking",
        //                "isFavourite": false,
        //                "description": "Light aerobic activity ideal for recovery",
        //                "icon": "walk-icon.svg",
        //                "typeOfWorkout": "CARDIO"
        //            },
        //            "reps": "1",
        //            "weight": "12"
        //        },
        //        {
        //            "exercise": {
        //                "id": 2,
        //                "typeName": "Cycling",
        //                "isFavourite": false,
        //                "description": "Cardio training on a stationary or outdoor bike",
        //                "icon": "bike-icon.svg",
        //                "typeOfWorkout": "CARDIO"
        //            },
        //            "reps": "1",
        //            "weight": "122"
        //        },
        //        {
        //            "exercise": {
        //                "id": 2,
        //                "typeName": "Cycling",
        //                "isFavourite": false,
        //                "description": "Cardio training on a stationary or outdoor bike",
        //                "icon": "bike-icon.svg",
        //                "typeOfWorkout": "CARDIO"
        //            },
        //            "reps": "4",
        //            "weight": "12"
        //        },
        //        {
        //            "exercise": {
        //                "id": 8,
        //                "typeName": "Push-ups",
        //                "isFavourite": false,
        //                "description": "Classic bodyweight exercise for chest and triceps",
        //                "icon": "pushup-icon.svg",
        //                "typeOfWorkout": "STRENGTH"
        //            },
        //            "reps": "4",
        //            "weight": "4"
        //        }
        //    ]
        //}

        workoutRepository.save(workout);
        return ResponseEntity.ok("Workout added successfully: " + workoutRequest.getWorkoutName());
    }
}
