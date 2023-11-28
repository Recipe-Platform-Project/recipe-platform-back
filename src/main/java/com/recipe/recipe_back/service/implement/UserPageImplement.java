package com.recipe.recipe_back.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.recipe.recipe_back.common.object.UserReviewListItem;
import com.recipe.recipe_back.dto.request.userPage.PatchProfileCommentRequestDto;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.chef.GetChefSearchListResponseDto;
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
import com.recipe.recipe_back.entity.BoardEntity;
import com.recipe.recipe_back.entity.ReviewEntity;
import com.recipe.recipe_back.entity.SubscirbeEntity;
import com.recipe.recipe_back.entity.UserEntity;
import com.recipe.recipe_back.repository.ToUserFromUserRepository;
import com.recipe.recipe_back.repository.UserCommentRepository;
import com.recipe.recipe_back.repository.UserRecipeRepository;
import com.recipe.recipe_back.repository.UserRepository;
import com.recipe.recipe_back.repository.UserReviewRepository;
import com.recipe.recipe_back.repository.resultSet.ChefListResultSet;
import com.recipe.recipe_back.repository.resultSet.UserRecipeListResultSet;
import com.recipe.recipe_back.repository.resultSet.UserRepleCommentListResultSet;
import com.recipe.recipe_back.repository.resultSet.UserReviewListResultSet;
import com.recipe.recipe_back.service.UserPageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserPageImplement implements UserPageService {

    private final UserRepository userRepository;
    private final UserRecipeRepository userRecipeRepository;
    private final UserReviewRepository userReviewRepository;
    private final UserCommentRepository userCommentRepository;
    private final ToUserFromUserRepository toUserFromUserRepository;

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

        List<UserRecipeListResultSet> resultSets = new ArrayList<>();

        try {
            
            boolean existedUser = userRepository.existsByEmail(email);
            if (!existedUser) return GetSignInUserRecipeResponseDto.notExistUser();

            resultSets = userRecipeRepository.findByRecipe();
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetSignInUserRecipeResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super GetUserRecipeSearchListResponseDto> getUserRecipeSearchList(String searchWord) {

        List<UserRecipeListResultSet> resultSets = new ArrayList<>();

        try {

            boolean existedUser = userRepository.existsByEmail(searchWord);
            if (!existedUser) return GetUserRecipeSearchListResponseDto.notExistBoard();

            resultSets = userRecipeRepository.findByUserRecipeSearchList(searchWord);
        
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetUserRecipeSearchListResponseDto.success(resultSets);
    }
    
    @Override
    public ResponseEntity<? super GetUserRecipeResponseDto> getUserRecipe() {

        List<UserRecipeListResultSet> resultSets = new ArrayList<>();

        try {

            resultSets = userRecipeRepository.findByRecipe();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetUserRecipeResponseDto.success(resultSets);
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
    public ResponseEntity<? super GetUserReviewListResponseDto> getUserReviewList(String email) {

        List<UserReviewListResultSet> resultSets = new ArrayList<>();

        try {

            boolean existedUser = userRepository.existsByEmail(email);
            if (!existedUser) return GetUserReviewListResponseDto.notExistUser();

            resultSets = userReviewRepository.findByReviewList();
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetUserReviewListResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super GetUserWriteReviewListResponseDto> getUserWriteReviewList(String email) {
        
        List<UserReviewListResultSet> resultSets = new ArrayList<>();
        
        try {
            
            boolean existedUser = userRepository.existsByEmail(email);
            if (!existedUser) return GetUserReviewListResponseDto.notExistUser();
            
            resultSets = userReviewRepository.findByReviewList();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetUserWriteReviewListResponseDto.success(resultSets);
        
    }

    @Override
    public ResponseEntity<? super GetUserRepleCommentResponseDto> getUserRepleComment(String email) {
        
        List<UserRepleCommentListResultSet> resultSets = new ArrayList<>();

        try {
            
            boolean existedUser = userRepository.existsByEmail(email);
            if (!existedUser) return GetUserRepleCommentResponseDto.notExistUser();

            resultSets = userCommentRepository.findByRepleCommentList();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetUserRepleCommentResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super GetUserWriteRepleCommentResponseDto> getUserWriteRepleComment(String email) {
        List<UserRepleCommentListResultSet> resultSets = new ArrayList<>();

        try {
            
            boolean existedUser = userRepository.existsByEmail(email);
            if (!existedUser) return GetUserWriteRepleCommentResponseDto.notExistBoard();

            resultSets = userCommentRepository.findByRepleCommentList();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetUserWriteRepleCommentResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super PutToUserFromUserResponseDto> putToUserFromUser(String toUser, String fromUser) {
        
        try {

            UserEntity fromUserEntity = userRepository.findByEmail(fromUser);
            if (fromUserEntity == null) return PutToUserFromUserResponseDto.notExistUser();

            UserEntity toUserEntity = userRepository.findByEmail(toUser);
            if (toUserEntity == null) return PutToUserFromUserResponseDto.notExistUser();

            SubscirbeEntity toUserFromUser = toUserFromUserRepository.findByToUserAndFromUser(toUser, fromUser);

            if (toUserFromUser == null) {
                toUserFromUser = new SubscirbeEntity(toUser, fromUser);
                toUserFromUserRepository.save(toUserFromUser);
                toUserEntity.increaseFollowingCount();
                fromUserEntity.increaseFollowCount();
            } else {
                toUserFromUserRepository.delete(toUserFromUser);
                toUserEntity.decreaseFollowingCount();
                fromUserEntity.decreaseFollowCount();
            }

            userRepository.save(toUserEntity);
            userRepository.save(fromUserEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PutToUserFromUserResponseDto.success();
    }
    
}
