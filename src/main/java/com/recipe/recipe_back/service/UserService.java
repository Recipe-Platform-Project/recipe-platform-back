package com.recipe.recipe_back.service;

import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.dto.request.user.PatchNicknameRequestDto;
import com.recipe.recipe_back.dto.request.user.PatchProfileImageRequestDto;

import com.recipe.recipe_back.dto.request.user.PatchUserPwRequestDto;
import com.recipe.recipe_back.dto.response.user.MembershipWithdrawalResposneDto;
import com.recipe.recipe_back.dto.response.user.PatchNicknameResponseDto;
import com.recipe.recipe_back.dto.response.user.PatchProfileImageResponseDto;
import com.recipe.recipe_back.dto.response.user.PatchUserPwResponseDto;

public interface UserService {

    ResponseEntity<? super PatchNicknameResponseDto> patchNickname(PatchNicknameRequestDto dto, String email);

    ResponseEntity<? super PatchProfileImageResponseDto> patchProfileImage(PatchProfileImageRequestDto dto,
            String email);

    ResponseEntity<? super PatchUserPwResponseDto> patchUserPassword(PatchUserPwRequestDto dto, String email);
    ResponseEntity<? super MembershipWithdrawalResposneDto> withdrawal(String email);
}
