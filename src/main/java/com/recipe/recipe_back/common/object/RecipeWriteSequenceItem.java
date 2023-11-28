package com.recipe.recipe_back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.recipe.recipe_back.entity.RecipeWriteSequenceEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeWriteSequenceItem {
    private int writeNumber;
    private String writeContent;
    private String writeImage;

    public RecipeWriteSequenceItem(int writeNumber, String writeContent, String writeImage) {
        this.writeNumber = writeNumber;
        this.writeContent = writeContent;
        this.writeImage = writeImage;
    }

    public RecipeWriteSequenceItem(RecipeWriteSequenceEntity entity) {

    }
}
