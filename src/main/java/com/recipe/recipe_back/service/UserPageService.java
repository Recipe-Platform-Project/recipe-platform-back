package com.recipe.recipe_back.service;

import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.dto.request.userPage.PatchProfileCommentRequestDto;
import com.recipe.recipe_back.dto.response.userPage.GetSignInUserRecipeResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetSignInUserResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetUserRecipeResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetUserRecipeSearchListResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetUserRepleCommentResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetUserReviewListResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetUserWriteRepleCommentResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetUserResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetUserWriteReviewListResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetUserWritingRecipeListResponseDto;
import com.recipe.recipe_back.dto.response.userPage.PatchProfileCommentResponseDto;
import com.recipe.recipe_back.dto.response.userPage.PutToUserFromUserResponseDto;

public interface UserPageService {

    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);
    ResponseEntity<? super GetUserResponseDto> getUser(String nickname);

    ResponseEntity<? super GetUserRecipeResponseDto> getUserRecipe();
    ResponseEntity<? super GetSignInUserRecipeResponseDto> getSignInUSerRecipe(String email);
    ResponseEntity<? super GetUserRecipeSearchListResponseDto> getUserRecipeSearchList(String searchWord);
    ResponseEntity<? super GetUserWritingRecipeListResponseDto> getUserWritingRecipeList(String email);
    ResponseEntity<? super GetUserReviewListResponseDto> getUserReviewList(String email);
    ResponseEntity<? super GetUserWriteReviewListResponseDto> getUserWriteReviewList(String email);
    ResponseEntity<? super GetUserRepleCommentResponseDto> getUserRepleComment(String email);
    ResponseEntity<? super GetUserWriteRepleCommentResponseDto> getUserWriteRepleComment(String email);

    ResponseEntity<? super PutToUserFromUserResponseDto> putToUserFromUser(String toUser, String fromUser);
    
    ResponseEntity<? super PatchProfileCommentResponseDto> patchProfileComment(PatchProfileCommentRequestDto dto, String email);
    
}
