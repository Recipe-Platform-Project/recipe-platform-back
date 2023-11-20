package com.recipe.recipe_back.service;

import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.dto.request.userPage.PatchProfileCommentRequestDto;
import com.recipe.recipe_back.dto.response.userPage.GetSignInUserRecipeResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetSignInUserResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetUserRecipeResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetUserRecipeReviewListResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetUserResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetUserWritingRecipeListResponseDto;
import com.recipe.recipe_back.dto.response.userPage.PatchProfileCommentResponseDto;

public interface UserPageService {

    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);
    ResponseEntity<? super GetUserResponseDto> getUser(String nickname);

    ResponseEntity<? super GetUserRecipeResponseDto> getUserRecipe();
    ResponseEntity<? super GetSignInUserRecipeResponseDto> getSignInUSerRecipe(String email);
    ResponseEntity<? super GetUserWritingRecipeListResponseDto> getUserWritingRecipeList(String email);
    ResponseEntity<? super GetUserRecipeReviewListResponseDto> getUserRecipeReviewList(String email);
    
    ResponseEntity<? super PatchProfileCommentResponseDto> patchProfileComment(PatchProfileCommentRequestDto dto, String email);
    
}
