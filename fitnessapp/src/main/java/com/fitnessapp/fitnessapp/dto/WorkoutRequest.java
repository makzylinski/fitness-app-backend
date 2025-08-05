package com.fitnessapp.fitnessapp.dto;

import java.util.Date;

public class WorkoutRequest {
    private String workoutName;
    private String note;
    private Date date;

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
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
