package com.fitnessapp.fitnessapp.dto;

import java.time.LocalDate;
import java.util.List;

public class WorkoutDTO {
    private Long id;
    private String workoutName;
    private LocalDate date;
    private String note;
    private List<ExerciseDTO> exercises;

    public WorkoutDTO(Long id, String workoutName, LocalDate date, String note, List<ExerciseDTO> exercises) {
        this.id = id;
        this.workoutName = workoutName;
        this.date = date;
        this.note = note;
        this.exercises = exercises;
    }

    public Long getId() { return id; }
    public String getWorkoutName() { return workoutName; }
    public LocalDate getDate() { return date; }
    public String getNote() { return note; }
    public List<ExerciseDTO> getExercises() { return exercises; }
}