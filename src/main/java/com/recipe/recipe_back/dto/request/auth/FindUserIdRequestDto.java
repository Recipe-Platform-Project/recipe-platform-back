package com.recipe.recipe_back.dto.request.auth;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindUserIdRequestDto {
    
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String telNumber;
}
