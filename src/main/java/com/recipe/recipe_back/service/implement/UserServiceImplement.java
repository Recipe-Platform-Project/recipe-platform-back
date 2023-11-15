package com.recipe.recipe_back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.recipe.recipe_back.dto.request.user.PatchNicknameRequestDto;
import com.recipe.recipe_back.dto.request.user.PatchProfileImageRequestDto;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.auth.FindUserIdResponseDto;
import com.recipe.recipe_back.dto.response.user.PatchNicknameResponseDto;
import com.recipe.recipe_back.dto.response.user.PatchProfileImageResponseDto;
import com.recipe.recipe_back.entity.UserEntity;
import com.recipe.recipe_back.repository.UserRepository;
import com.recipe.recipe_back.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

    private final UserRepository userRepository;
    
    @Override
    public ResponseEntity<? super PatchNicknameResponseDto> patchNickname(PatchNicknameRequestDto dto, String email) {
        try {
            
            String nickname = dto.getNickname();
            boolean existedNickname = userRepository.existsByNickname(nickname);
            if(existedNickname) return PatchNicknameResponseDto.duplicateNickname();

            UserEntity userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return PatchNicknameResponseDto.notExistUser();

            userEntity.patchNickname(dto);
            userRepository.save(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PatchNicknameResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchProfileImageResponseDto> patchProfileImage(PatchProfileImageRequestDto dto, String email) {
        try {

            UserEntity userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return PatchProfileImageResponseDto.notExistUser();

            userEntity.patchProfileImage(dto);
            userRepository.save(userEntity);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PatchProfileImageResponseDto.success();
    }

    
}
