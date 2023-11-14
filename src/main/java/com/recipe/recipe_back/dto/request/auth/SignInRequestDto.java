package com.recipe.recipe_back.dto.request.auth;


import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignInRequestDto {
    @NotBlank
    private String email;
    
    @NotBlank
    private String password;
}
