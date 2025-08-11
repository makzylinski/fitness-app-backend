package com.fitnessapp.fitnessapp.service;

import com.fitnessapp.fitnessapp.model.WorkoutType;
import com.fitnessapp.fitnessapp.repository.WorkoutTypeRepository;

import java.util.List;

public class WorkoutTypeService {
    private final WorkoutTypeRepository workoutTypeRepository;

    public WorkoutTypeService(WorkoutTypeRepository workoutTypeRepository) {
        this.workoutTypeRepository = workoutTypeRepository;
    }

    public List<WorkoutType> getAllWorkoutTypes() {
        return workoutTypeRepository.findAll();
    }
}
