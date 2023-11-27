package com.recipe.recipe_back.service;

import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.dto.request.userPage.PatchProfileCommentRequestDto;
import com.recipe.recipe_back.dto.response.userPage.GetSignInUserResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetUserResponseDto;
import com.recipe.recipe_back.dto.response.userPage.PatchProfileCommentResponseDto;

public interface UserPageService {

    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);
    ResponseEntity<? super GetUserResponseDto> getUser(String nickname);
    
    ResponseEntity<? super PatchProfileCommentResponseDto> patchProfileComment(PatchProfileCommentRequestDto dto, String email);
    
}
