package com.recipe.recipe_back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.recipe.recipe_back.dto.request.board.PostRecipeWriteSequenceRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "recipe_write_sequence")
@Table(name = "recipe_write_sequence")
public class RecipeWriteSequenceEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sequenceIndex;
    private int boardNumber;
    private int writeNumber;
    private String writeContent;
    private String writeImage;

    public RecipeWriteSequenceEntity(PostRecipeWriteSequenceRequestDto dto, Integer boardNumber){

        this.boardNumber = boardNumber;
        this.writeNumber = dto.getWriteNumber();
        this.writeContent = dto.getWriteContent();
        this.writeImage = dto.getWriteImaga();
    }
}
