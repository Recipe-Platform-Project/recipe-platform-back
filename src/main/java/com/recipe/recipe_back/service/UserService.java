package com.recipe.recipe_back.service;

import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.dto.request.user.PatchNicknameRequestDto;
import com.recipe.recipe_back.dto.request.user.PatchProfileImageRequestDto;
import com.recipe.recipe_back.dto.response.user.PatchNicknameResponseDto;
import com.recipe.recipe_back.dto.response.user.PatchProfileImageResponseDto;

public interface UserService {

    ResponseEntity<? super PatchNicknameResponseDto> patchNickname(PatchNicknameRequestDto dto, String email);
    ResponseEntity<? super PatchProfileImageResponseDto> patchProfileImage(PatchProfileImageRequestDto dto, String email);

}
