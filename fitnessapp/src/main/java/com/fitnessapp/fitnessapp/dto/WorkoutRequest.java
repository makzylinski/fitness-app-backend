package com.fitnessapp.fitnessapp.dto;

import java.util.Date;

public class WorkoutRequest {
    private String name;
    private String note;
    private Date date;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
