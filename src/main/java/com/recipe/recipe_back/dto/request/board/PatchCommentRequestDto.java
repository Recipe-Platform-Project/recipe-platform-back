package com.recipe.recipe_back.dto.request.board;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchCommentRequestDto {
    @NotBlank
    private String contents;
}
