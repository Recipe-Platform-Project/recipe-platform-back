package com.recipe.recipe_back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.recipe_back.dto.request.user.PatchNicknameRequestDto;
import com.recipe.recipe_back.dto.request.user.PatchProfileImageRequestDto;
import com.recipe.recipe_back.dto.request.user.PatchUserPwRequestDto;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.user.MembershipWithdrawalResposneDto;
import com.recipe.recipe_back.dto.response.user.PatchNicknameResponseDto;
import com.recipe.recipe_back.dto.response.user.PatchProfileImageResponseDto;
import com.recipe.recipe_back.dto.response.user.PatchUserPwResponseDto;
import com.recipe.recipe_back.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PatchMapping("/nickname")
    public ResponseEntity<? super PatchNicknameResponseDto> patchNickname(@RequestBody @Valid PatchNicknameRequestDto requestBody, @AuthenticationPrincipal String email){
        ResponseEntity<? super PatchNicknameResponseDto> response = userService.patchNickname(requestBody, email);
        return response;
    }

    @PatchMapping("/profileImage")
    public ResponseEntity<? super PatchProfileImageResponseDto> patchProfileImage(@RequestBody @Valid PatchProfileImageRequestDto requestBody, @AuthenticationPrincipal String email){
        ResponseEntity<? super PatchProfileImageResponseDto> response = userService.patchProfileImage(requestBody, email);
        return response;
    }

    @PatchMapping("/password-change")
    public ResponseEntity<? super PatchUserPwResponseDto> patchUserPassword(@RequestBody @Valid PatchUserPwRequestDto requestBody, @AuthenticationPrincipal String email){
        ResponseEntity<? super PatchUserPwResponseDto> response = userService.patchUserPassword(requestBody, email);
        return response;
    }

    @DeleteMapping("/{userEmail}")
    public ResponseEntity<? super MembershipWithdrawalResposneDto> withdrawal(@PathVariable("userEmail") String userEmail, @AuthenticationPrincipal String email) {
        ResponseEntity<? super MembershipWithdrawalResposneDto> response = userService.withdrawal(email);
        return response;
    }
}
