package com.fitnessapp.fitnessapp.dto;

import com.fitnessapp.fitnessapp.model.TypeOfWorkout;

public class ExerciseDTO {
    private Long id;
    private String typeName;
    private String description;
    private String icon;
    private TypeOfWorkout typeOfWorkout;
    private String reps;
    private String weight;

    public ExerciseDTO(Long id, String typeName, String description, String icon, TypeOfWorkout typeOfWorkout, String reps, String weight) {
        this.id = id;
        this.typeName = typeName;
        this.description = description;
        this.icon = icon;
        this.typeOfWorkout = typeOfWorkout;
        this.reps = reps;
        this.weight = weight;
    }

    public Long getId() { return id; }
    public String getTypeName() { return typeName; }
    public String getDescription() { return description; }
    public String getIcon() { return icon; }
    public TypeOfWorkout getTypeOfWorkout() { return typeOfWorkout; }
    public String getReps() { return reps; }
    public String getWeight() { return weight; }
}