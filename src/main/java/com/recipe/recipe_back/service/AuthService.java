package com.recipe.recipe_back.service;

import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.dto.request.auth.FindUserIdRequestDto;
import com.recipe.recipe_back.dto.request.auth.SignInRequestDto;
import com.recipe.recipe_back.dto.request.auth.SignUpRequestDto;
import com.recipe.recipe_back.dto.request.user.PatchNicknameRequestDto;
import com.recipe.recipe_back.dto.response.auth.SignInResponseDto;
import com.recipe.recipe_back.dto.response.auth.SignUpResponseDto;
import com.recipe.recipe_back.dto.response.user.FindUserIdResponseDto;
import com.recipe.recipe_back.dto.response.user.PatchNicknameResponseDto;

public interface AuthService {
    
    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);

    ResponseEntity<? super FindUserIdResponseDto> findeUserId(FindUserIdRequestDto dto);
}
