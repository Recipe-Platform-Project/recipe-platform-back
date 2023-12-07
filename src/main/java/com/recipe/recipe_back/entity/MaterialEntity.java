package com.recipe.recipe_back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "material")
@Table(name = "material")
public class MaterialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int materialSequence;
    private int mainMaterialFK;
    private String materials;
    private String measurement;

    public MaterialEntity(Integer materialCategoriesSequence, String materials, String measurement) {
        this.mainMaterialFK = materialCategoriesSequence;
        this.materials = materials;
        this.measurement = measurement;
    }
}
