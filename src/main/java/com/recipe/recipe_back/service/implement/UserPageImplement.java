package com.recipe.recipe_back.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.recipe.recipe_back.common.object.UserRecipeReviewListItem;
import com.recipe.recipe_back.dto.request.userPage.PatchProfileCommentRequestDto;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetSignInUserRecipeResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetSignInUserResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetUserRecipeResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetUserRecipeReviewListResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetUserResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetUserWritingRecipeListResponseDto;
import com.recipe.recipe_back.dto.response.userPage.PatchProfileCommentResponseDto;
import com.recipe.recipe_back.entity.BoardEntity;
import com.recipe.recipe_back.entity.ReviewEntity;
import com.recipe.recipe_back.entity.UserEntity;
import com.recipe.recipe_back.repository.ReviewRepository;
import com.recipe.recipe_back.repository.UserPageRepository;
import com.recipe.recipe_back.repository.UserRepository;
import com.recipe.recipe_back.service.UserPageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserPageImplement implements UserPageService {

    private final UserRepository userRepository;
    private final UserPageRepository userPageRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public ResponseEntity<? super PatchProfileCommentResponseDto> patchProfileComment(PatchProfileCommentRequestDto dto, String email) {

        try {

            UserEntity userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return PatchProfileCommentResponseDto.notExistUser();
            
            userEntity.patchProfileComment(dto);
            userRepository.save(userEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PatchProfileCommentResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email) {

        UserEntity userEntity;
        try { 
            
            userEntity = userRepository.findByEmail(email);
            if (userEntity == null) return GetSignInUserResponseDto.notExistUser();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetSignInUserResponseDto.success(userEntity);
    }

    @Override
    public ResponseEntity<? super GetUserResponseDto> getUser(String nickname) {

        UserEntity userEntity;

        try {

            userEntity = userRepository.findByEmail(nickname);
            if (userEntity == null) return GetUserResponseDto.notExistUser();
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetUserResponseDto.success(userEntity);
    }

    @Override
    public ResponseEntity<? super GetSignInUserRecipeResponseDto> getSignInUSerRecipe(String email) {

        List<BoardEntity> boardEntities = new ArrayList<>();
        List<UserEntity> userEntities = new ArrayList<>();

        try {

            // boardEntities = userPageRepository.findByOrderByWriteDatetime();
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetSignInUserRecipeResponseDto.success(boardEntities, userEntities);
    }

    @Override
    public ResponseEntity<? super GetUserRecipeResponseDto> getUserRecipe() {

        List<BoardEntity> boardEntities = new ArrayList<>();
        List<UserEntity> userEntities = new ArrayList<>();


        try {

            if (boardEntities == null) return GetUserRecipeResponseDto.notExistBoard();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetUserRecipeResponseDto.success(boardEntities, userEntities);
    }

    @Override
    public ResponseEntity<? super GetUserWritingRecipeListResponseDto> getUserWritingRecipeList(String email) {

        BoardEntity boardEntity = null;

        try {

            if (boardEntity == null) return GetUserWritingRecipeListResponseDto.notExistBoard();
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetUserWritingRecipeListResponseDto.success(boardEntity);
    }

    @Override
    public ResponseEntity<? super GetUserRecipeReviewListResponseDto> getUserRecipeReviewList(String email) {

        List<BoardEntity> boardEntities = new ArrayList<>();
        List<ReviewEntity> reviewEntities = new ArrayList<>();

        try {

            reviewEntities = reviewRepository.findByOrderByWriteDateTimeDesc();
            
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetUserRecipeReviewListResponseDto.success(boardEntities, reviewEntities);
    }

    


    

    
    
}
