package com.recipe.recipe_back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.recipe_back.dto.request.auth.FindUserIdRequestDto;
import com.recipe.recipe_back.dto.request.auth.FindUserPwRequestDto;
import com.recipe.recipe_back.dto.request.auth.SignInRequestDto;
import com.recipe.recipe_back.dto.request.auth.SignUpRequestDto;
import com.recipe.recipe_back.dto.response.auth.FindUserIdResponseDto;
import com.recipe.recipe_back.dto.response.auth.FindUserPwResponseDto;
import com.recipe.recipe_back.dto.response.auth.SignInResponseDto;
import com.recipe.recipe_back.dto.response.auth.SignUpResponseDto;
import com.recipe.recipe_back.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthService authService;

    @PostMapping("/signUp")
    public ResponseEntity<? super SignUpResponseDto> signUp(@RequestBody @Valid SignUpRequestDto requestBody){
        ResponseEntity<? super SignUpResponseDto> response = authService.signUp(requestBody);
        return response;
    }

    @PostMapping("/signIn")
    public ResponseEntity <? super SignInResponseDto> signIn(@RequestBody @Valid SignInRequestDto requestBody){
        ResponseEntity<? super SignInResponseDto> response = authService.signIn(requestBody);
        return response;
    }


    @PostMapping("/found-email")
    public ResponseEntity <? super FindUserIdResponseDto> findUserEmail(@RequestBody @Valid FindUserIdRequestDto requestBody){
        ResponseEntity<? super FindUserIdResponseDto> response = authService.findUserId(requestBody);
        return response;
    }

    @PatchMapping("/found-password")
    public ResponseEntity<? super FindUserPwResponseDto> findUserPassword(@RequestBody @Valid FindUserPwRequestDto requestBody){
        ResponseEntity<? super FindUserPwResponseDto> response = authService.findUserPw(requestBody);
        return response;
    }
    
    // @GetMapping("/found-email")
    // public ResponseEntity<? super FindUserIdResponseDto> findUserEmail(@RequestParam("name") String name, @RequestParam("telNumber") String telNumber) {
    //     ResponseEntity<? super FindUserIdResponseDto> response = authService.findeUserId(name, telNumber);
    //     return response;
    // }
    
}
