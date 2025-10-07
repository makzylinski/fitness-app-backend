package com.fitnessapp.fitnessapp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

public class WorkoutSet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "workout_exercise_id")
    private WorkoutExercise workoutExercise;

    @Column(name = "set_index", nullable = false)
    private int setIndex;

    private Integer reps;
    private BigDecimal weight;
    private Integer durationSeconds;
    private String notes;

    public WorkoutSet() {
    }

    public WorkoutSet(WorkoutExercise workoutExercise, int setIndex, Integer reps, BigDecimal weight, Integer durationSeconds, String notes) {
        this.workoutExercise = workoutExercise;
        this.setIndex = setIndex;
        this.reps = reps;
        this.weight = weight;
        this.durationSeconds = durationSeconds;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public WorkoutExercise getWorkoutExercise() {
        return workoutExercise;
    }
    public void setWorkoutExercise(WorkoutExercise workoutExercise) {
        this.workoutExercise = workoutExercise;
    }
    public int getSetIndex() {
        return setIndex;
    }
    public void setSetIndex(int setIndex) {
        this.setIndex = setIndex;
    }
    public Integer getReps() {
        return reps;
    }
    public void setReps(Integer reps) {
        this.reps = reps;
    }
    public BigDecimal getWeight() {
        return weight;
    }
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
    public Integer getDurationSeconds() {
        return durationSeconds;
    }
    public void setDurationSeconds(Integer durationSeconds) {
        this.durationSeconds = durationSeconds;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

}
