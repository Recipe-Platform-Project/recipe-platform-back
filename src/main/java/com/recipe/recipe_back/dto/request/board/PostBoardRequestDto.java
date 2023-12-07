package com.recipe.recipe_back.dto.request.board;

import javax.validation.constraints.NotBlank;

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
    private String writeDatetime;
    @NotBlank
    private String kindCategory;
    @NotBlank
    private String wayCategory;
    @NotBlank
    private String materialCategory;
    @NotBlank
    private String requiredTime;
    @NotBlank
    private String difficulty;
    @NotBlank
    private String peopleCount;
    private String videoLink;
    private int viewCount;
    private String userEmail;
    private int commnetCount;
    private int favoriteCount;

    
}
