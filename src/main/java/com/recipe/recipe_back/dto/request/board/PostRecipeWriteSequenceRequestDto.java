package com.recipe.recipe_back.dto.request.board;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostRecipeWriteSequenceRequestDto {
    @NotNull
    private String writeContent;
    @NotNull
    private String writeImage;
    @NotNull
    private int writeNumber;
}
