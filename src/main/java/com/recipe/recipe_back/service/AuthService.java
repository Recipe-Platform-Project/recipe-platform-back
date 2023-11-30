package com.recipe.recipe_back.service;

import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.dto.request.auth.FindUserIdRequestDto;
import com.recipe.recipe_back.dto.request.auth.FindUserPwRequestDto;
import com.recipe.recipe_back.dto.request.auth.SignInRequestDto;
import com.recipe.recipe_back.dto.request.auth.SignUpRequestDto;
import com.recipe.recipe_back.dto.response.auth.FindUserIdResponseDto;
import com.recipe.recipe_back.dto.response.auth.FindUserPwResponseDto;
import com.recipe.recipe_back.dto.response.auth.SignInResponseDto;
import com.recipe.recipe_back.dto.response.auth.SignUpResponseDto;

public interface AuthService {
    
    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);

    ResponseEntity<? super FindUserIdResponseDto> findUserId(FindUserIdRequestDto dto);
    ResponseEntity<? super FindUserPwResponseDto> findUserPw(FindUserPwRequestDto dto);

}
