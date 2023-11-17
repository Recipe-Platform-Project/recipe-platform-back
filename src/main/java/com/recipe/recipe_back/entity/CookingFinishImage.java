package com.recipe.recipe_back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="cooking_finish_image")
@Table(name="cooking_finish_image")
public class CookingFinishImage {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int sequence;
    private int boardNumber;
    private String imageUrl;

    public CookingFinishImage (int boardNumber, String imageUrl) {
        this.boardNumber = boardNumber;
        this.imageUrl = imageUrl;
    }
    
}
