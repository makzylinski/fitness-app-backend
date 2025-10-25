package com.fitnessapp.fitnessapp.mapper;

import com.fitnessapp.fitnessapp.dto.ExerciseDTO;
import com.fitnessapp.fitnessapp.dto.WorkoutDTO;
import com.fitnessapp.fitnessapp.model.Exercise;
import com.fitnessapp.fitnessapp.model.Workout;

import java.util.List;

public class WorkoutMapper {

    public static WorkoutDTO toDto(Workout workout) {
        List<ExerciseDTO> exercises = workout.getExercises().stream()
                .map(WorkoutMapper::toDto)
                .toList();

        return new WorkoutDTO(
                workout.getId(),
                workout.getWorkoutName(),
                workout.getDate(),
                workout.getNote(),
                exercises
        );
    }

    private static ExerciseDTO toDto(Exercise exercise) {
        return new ExerciseDTO(
                exercise.getId(),
                exercise.getTypeName(),
                exercise.getDescription(),
                exercise.getIcon(),
                exercise.getTypeOfWorkout(),
                exercise.getReps(),
                exercise.getWeight()
        );
    }
}