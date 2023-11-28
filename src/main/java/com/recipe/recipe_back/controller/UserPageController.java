package com.recipe.recipe_back.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.recipe.recipe_back.service.UserPageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserPageController {

    private final UserPageService userPageService;

    @PatchMapping("/introduction")
    public ResponseEntity<? super PatchProfileCommentResponseDto> patchProfileComment(
        @RequestBody @Valid PatchProfileCommentRequestDto requestBody,
        @PathVariable("nickname") String nickname,
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super PatchProfileCommentResponseDto> response = userPageService.patchProfileComment(requestBody, email);
        return response;
    }

    @GetMapping("")
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super GetSignInUserResponseDto> response = userPageService.getSignInUser(email);
        return response;
    }

    @GetMapping("/{nickname}")
    public ResponseEntity<? super GetUserResponseDto> getUser(
        @PathVariable("nickname") String nickname
    ) {
        ResponseEntity<? super GetUserResponseDto> response = userPageService.getUser(nickname);
        return response;
    }

    @GetMapping("/recipe-list")
    public ResponseEntity<? super GetSignInUserRecipeResponseDto> getSignInUserRecipe(
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super GetSignInUserRecipeResponseDto> response = userPageService.getSignInUSerRecipe(email);
        return response;
    }

    @GetMapping("/{nickname}/user-recipe-list")
    public ResponseEntity<? super GetUserRecipeResponseDto> getUserRecipe(
        @PathVariable("nickname") String nickname
    ) {
        ResponseEntity<? super GetUserRecipeResponseDto> response = userPageService.getUserRecipe();
        return response;
    }

    @GetMapping("/user-recipe-search/{searchWord}")
    public ResponseEntity<? super GetUserRecipeSearchListResponseDto> getUserRecipeSearchList(
        @PathVariable("searchWord") String searchWord
    ) {
        ResponseEntity<? super GetUserRecipeSearchListResponseDto> response = userPageService.getUserRecipeSearchList(searchWord);
        return response;
    }

    @GetMapping("/user-writing-recipe-list")
    public ResponseEntity<? super GetUserWritingRecipeListResponseDto> getUserWritingRecipeList(
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super GetUserWritingRecipeListResponseDto> response = userPageService.getUserWritingRecipeList(email);
        return response;
    }

    @GetMapping("/user-recipe-review-list")
    public ResponseEntity<? super GetUserReviewListResponseDto> getUserRecipeReviewList(
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super GetUserReviewListResponseDto> response = userPageService.getUserReviewList(email);
        return response;
    }

    @GetMapping("/user-write-recipe-review-list")
    public ResponseEntity<? super GetUserWriteReviewListResponseDto> getUserWriteRecipeReviewList(
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super GetUserWriteReviewListResponseDto> response = userPageService.getUserWriteReviewList(email);
        return response;
    }

    @GetMapping("/user-comment-list")
    public ResponseEntity<? super GetUserRepleCommentResponseDto> getUserRepleComment(
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super GetUserRepleCommentResponseDto> response = userPageService.getUserRepleComment(email);
        return response;
    }

    @GetMapping("/user-write-comment-list")
    public ResponseEntity<? super GetUserWriteRepleCommentResponseDto> getUserWriteRepleComment(
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super GetUserWriteRepleCommentResponseDto> response = userPageService.getUserWriteRepleComment(email);
        return response;
    }

    @PutMapping("/{email}/subscirbe")
    public ResponseEntity<? super PutToUserFromUserResponseDto> putToUserFromUser(
        @PathVariable("email") String toUser,
        @AuthenticationPrincipal String fromUser
    ) {
        ResponseEntity<? super PutToUserFromUserResponseDto> response = userPageService.putToUserFromUser(toUser, fromUser);
        return response;
    }

    
}
