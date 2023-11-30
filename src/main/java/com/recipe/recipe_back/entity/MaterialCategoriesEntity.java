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
@Entity(name = "material_categories")
@Table(name = "material_categories")
public class MaterialCategoriesEntity {
    private int boardNumber;
    private String materialTitle;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int materialCategoriesSequence;

    public MaterialCategoriesEntity(int boardNumber, String materialTitle) {
        this.boardNumber = boardNumber;
        this.materialTitle = materialTitle;
    }
}
