package com.recipe.recipe_back.dto.request.user;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchUserPwRequestDto {
    
    @NotBlank
    private String password;

    @NotBlank
    private String newPassword;

    @NotBlank
    private String newPasswordCheck;
}
