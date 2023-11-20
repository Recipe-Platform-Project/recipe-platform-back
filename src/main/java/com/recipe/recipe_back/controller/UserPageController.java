package com.recipe.recipe_back.controller;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.recipe_back.dto.request.userPage.PatchProfileCommentRequestDto;
import com.recipe.recipe_back.dto.response.userPage.GetSignInUserRecipeResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetSignInUserResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetUserRecipeResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetUserRecipeReviewListResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetUserResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetUserWritingRecipeListResponseDto;
import com.recipe.recipe_back.dto.response.userPage.PatchProfileCommentResponseDto;
import com.recipe.recipe_back.service.UserPageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserPageController {

    private final UserPageService userPageService;

    @PatchMapping("/{nickname}/introduction")
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

    @GetMapping("/{nickname}/user-recipe-list")
    public ResponseEntity<? super GetSignInUserRecipeResponseDto> getSignInUserRecipe(
        @PathVariable("nickname") String nickname,
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

    @GetMapping("/{nickname}/user-writing-recipe-list")
    public ResponseEntity<? super GetUserWritingRecipeListResponseDto> getUserWritingRecipeList(
        @PathVariable("nickname") String nickname,
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super GetUserWritingRecipeListResponseDto> response = userPageService.getUserWritingRecipeList(email);
        return response;
    }

    @GetMapping("{nickname}/user-recipe-review-list")
    public ResponseEntity<? super GetUserRecipeReviewListResponseDto> getUserRecipeReviewList(
        @PathVariable("nickname") String nickname,
        @AuthenticationPrincipal String email
    ) {
        ResponseEntity<? super GetUserRecipeReviewListResponseDto> response = userPageService.getUserRecipeReviewList(email);
        return response;
    }

    
}
