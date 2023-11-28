package com.recipe.recipe_back.dto.request.board;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostReviewRequestDto {
    
    @NotBlank
    String contents;
    @NotNull
    int rating;
    
    String commentImage;
}
