package com.fitnessapp.fitnessapp.dto;

import com.fitnessapp.fitnessapp.model.TypeOfWorkout;

import java.time.LocalDate;
import java.util.List;

public class WorkoutRequest {
    private ExerciseDetails exerciseDetails;
    private List<Exercise> exercises;

    public ExerciseDetails getExerciseDetails() {
        return exerciseDetails;
    }

    public void setExerciseDetails(ExerciseDetails details) {
        this.exerciseDetails = details;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public static class ExerciseDetails {
        private String name;
        private String note;
        private LocalDate date;

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

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }
    }

    public static class Exercise {
        private Long id;
        private String typeName;
        private boolean isFavourite;
        private String description;
        private String icon;
        private TypeOfWorkout typeOfWorkout;
        private String reps;
        private String weight;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public boolean isFavourite() {
            return isFavourite;
        }

        public void setFavourite(boolean isFavourite) {
            this.isFavourite = isFavourite;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public TypeOfWorkout getTypeOfWorkout() {
            return typeOfWorkout;
        }

        public void setTypeOfWorkout(TypeOfWorkout typeOfWorkout) {
            this.typeOfWorkout = typeOfWorkout;
        }

        public String getReps() {
            return reps;
        }

        public void setReps(String reps) {
            this.reps = reps;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }
    }
}