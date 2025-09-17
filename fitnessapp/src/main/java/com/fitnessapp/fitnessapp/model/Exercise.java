package com.fitnessapp.fitnessapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String typeName;
    private boolean isFavourite;
    private String description;
    private String icon;
    private TypeOfWorkout typeOfWorkout;

    public Exercise() {
    }

    public Exercise(String typeName, boolean isFavourite, String description, String icon, TypeOfWorkout typeOfWorkout) {
        this.typeName = typeName;
        this.isFavourite = isFavourite;
        this.description = description;
        this.icon = icon;
        this.typeOfWorkout = typeOfWorkout;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
