package com.recipe.recipe_back.dto.request.board;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.recipe.recipe_back.common.object.RecipeWriteSequenceItem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostBoardRequestDto {

    @NotBlank
    private String boardMainImage;

    @NotBlank
    private String title;

    @NotBlank
    private String introduce;

    @NotNull
    private List<String> recipeWriteSequence;

    @NotNull
    private List<String> materialTitle;

    // @NotNull
    // private List<String> materials;

    // @NotNull
    // private List<String> measurement;

    @NotBlank
    private String kindCategory;

    @NotBlank
    private String wayCategory;

    @NotBlank
    private String materialCategory;

    private String videoLink;

    private String cookingTip;

    @NotBlank
    private String requiredTime;

    @NotBlank
    private String difficulty;

    @NotBlank
    private String peopleCount;

    private String recipeTag;

    @NotNull
    private List<String> imageUrlList;

}
