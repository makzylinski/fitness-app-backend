package com.fitnessapp.fitnessapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class WorkoutType {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String typeName;

    private Boolean isFavourite;
    private String description;
    private String icon;

    public WorkoutType() {
    }

    public WorkoutType(String typeName, Boolean isFavourite, String description, String icon) {
        this.typeName = typeName;
        this.isFavourite = isFavourite;
        this.description = description;
        this.icon = icon;
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
    public Boolean getIsFavourite() {
        return isFavourite;
    }
    public void setIsFavourite(Boolean isFavourite) {
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
}
