package com.recipe.recipe_back.dto.request.auth;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUpRequestDto {
    
    @NotBlank @Email
    private String email;

    @NotBlank @Size(min=8, max=20)
    private String password;

    @NotBlank @Size(min=2, max=8)
    private String nickname;

    @NotBlank
    private String name;

    @NotBlank @Pattern(regexp="^[0-9]{11,13}$")
    private String telNumber;

    @NotNull @AssertTrue
    private Boolean agreedPersonalEssential;

    @AssertTrue
    private Boolean agreedPersonCollection;

    @AssertTrue
    private Boolean agreedPersonProsessing;

    private String profileImageUrl;
}
