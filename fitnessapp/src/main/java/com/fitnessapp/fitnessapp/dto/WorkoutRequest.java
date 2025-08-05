package com.fitnessapp.fitnessapp.dto;

import java.time.LocalDate;

public class WorkoutRequest {
    private String workoutName;
    private String note;
    private LocalDate date;

    public String getWorkoutName() {
        return workoutName;
    }
    public void setWorkoutName(String name) {
        this.workoutName = name;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
