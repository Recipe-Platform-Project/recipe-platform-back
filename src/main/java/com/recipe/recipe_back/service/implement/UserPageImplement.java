package com.recipe.recipe_back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.recipe.recipe_back.dto.request.userPage.PatchProfileCommentRequestDto;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetSignInUserResponseDto;
import com.recipe.recipe_back.dto.response.userPage.GetUserResponseDto;
import com.recipe.recipe_back.dto.response.userPage.PatchProfileCommentResponseDto;
import com.recipe.recipe_back.entity.UserEntity;
import com.recipe.recipe_back.repository.UserRepository;
import com.recipe.recipe_back.service.UserPageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserPageImplement implements UserPageService {

    private final UserRepository userRepository;

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
    
}
