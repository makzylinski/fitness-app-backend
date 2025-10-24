package com.fitnessapp.fitnessapp.controller;

import com.fitnessapp.fitnessapp.dto.WorkoutRequest;
import com.fitnessapp.fitnessapp.model.Exercise;
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

import java.util.List;

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
                workoutRequest.getExerciseDetails().getNotes()
        );

        List<Exercise> exercises = workoutRequest.getExercises().stream().map(reqExercise -> {
            WorkoutRequest.ExerciseRequest.NestedExercise exerciseData = reqExercise.getExercise();

            Exercise exercise = new Exercise();
            exercise.setTypeName(exerciseData.getTypeName());
            exercise.setFavourite(exerciseData.isFavourite());
            exercise.setDescription(exerciseData.getDescription());
            exercise.setIcon(exerciseData.getIcon());
            exercise.setTypeOfWorkout(exerciseData.getTypeOfWorkout());
            exercise.setReps(reqExercise.getReps());
            exercise.setWeight(reqExercise.getWeight());
            exercise.setWorkout(workout);
            return exercise;
        }).toList();

        workout.setExercises(exercises);


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
        logger.info("Workout added successfully: {}", workout.getWorkoutName());
        return ResponseEntity.ok("Workout added successfully: " + workout.getWorkoutName());
    }
}