package com.recipe.recipe_back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.recipe.recipe_back.common.object.RecipeWriteSequenceItem;
import com.recipe.recipe_back.dto.request.board.PostRecipeWriteSequenceRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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

    public RecipeWriteSequenceEntity(Integer boardNumber, int writeNumber, String writeContent, String writeImage) {
        this.boardNumber = boardNumber;
        this.writeNumber = writeNumber;
        this.writeContent = writeContent;
        this.writeImage = writeImage;
    }
}
