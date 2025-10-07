package com.fitnessapp.fitnessapp.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class WorkoutExercise {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false) @JoinColumn(name = "workout_id")
    private Workout workout;

    @ManyToOne(optional = false) @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @Column(name = "order_index", nullable = false)
    private int orderIndex;

    @OneToMany(mappedBy = "workoutExercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkoutSet> sets = new ArrayList<>();

    public WorkoutExercise() {
    }

    public WorkoutExercise(Workout workout, Exercise exercise, int orderIndex) {
        this.workout = workout;
        this.exercise = exercise;
        this.orderIndex = orderIndex;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Workout getWorkout() {
        return workout;
    }
    public void setWorkout(Workout workout) {
        this.workout = workout;
    }
    public Exercise getExercise() {
        return exercise;
    }
    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
    public int getOrderIndex() {
        return orderIndex;
    }
    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }
    public List<WorkoutSet> getSets() {
        return sets;
    }
    public void setSets(List<WorkoutSet> sets) {
        this.sets = sets;
    }

}
