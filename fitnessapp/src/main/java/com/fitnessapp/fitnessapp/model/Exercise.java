package com.fitnessapp.fitnessapp.model;

import jakarta.persistence.*;

@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String typeName;
    private boolean isFavourite;
    private String description;
    private String icon;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeOfWorkout typeOfWorkout;
    private String reps;
    private String weight;
    @ManyToOne
    @JoinColumn(name = "workout_id", nullable = false)
    private Workout workout;

    public Exercise() {
    }

    public Exercise(String typeName, boolean isFavourite, String description, String icon, TypeOfWorkout typeOfWorkout) {
        this.typeName = typeName;
        this.isFavourite = isFavourite;
        this.description = description;
        this.icon = icon;
        this.typeOfWorkout = typeOfWorkout;
    }
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
    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
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
    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }
}