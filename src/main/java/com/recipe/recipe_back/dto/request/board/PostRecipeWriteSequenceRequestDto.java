package com.recipe.recipe_back.dto.request.board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostRecipeWriteSequenceRequestDto {

    private int writeNumber;
    private String writeImaga;
    private String writeContent;
}