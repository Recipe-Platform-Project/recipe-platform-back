package com.recipe.recipe_back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.recipe.recipe_back.dto.request.user.PatchNicknameRequestDto;
import com.recipe.recipe_back.dto.request.user.PatchProfileImageRequestDto;
import com.recipe.recipe_back.dto.request.user.PatchUserPwRequestDto;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.user.MembershipWithdrawalResposneDto;
import com.recipe.recipe_back.dto.response.user.PatchNicknameResponseDto;
import com.recipe.recipe_back.dto.response.user.PatchProfileImageResponseDto;
import com.recipe.recipe_back.dto.response.user.PatchUserPwResponseDto;
import com.recipe.recipe_back.entity.UserEntity;
import com.recipe.recipe_back.repository.UserRepository;
import com.recipe.recipe_back.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    
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

    @Override
    public ResponseEntity<? super PatchUserPwResponseDto> patchUserPassword(PatchUserPwRequestDto dto, String email) {
        
        try {

            String password = dto.getPassword();
            String newPassword = dto.getNewPassword();
            String newPasswordCheck = dto.getNewPasswordCheck();

            
            UserEntity userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return PatchUserPwResponseDto.notExistUser();

            if(password.equals(newPassword)){
                return PatchUserPwResponseDto.samePassword();
            }

            if(!newPassword.equals(newPasswordCheck)){
                return PatchUserPwResponseDto.passwordMissMatch();
            }

            userEntity.patchUserPassword(passwordEncoder.encode(newPassword));
            userRepository.save(userEntity);

            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PatchUserPwResponseDto.success();
    }

    @Override
    public ResponseEntity<? super MembershipWithdrawalResposneDto> withdrawal(String email) {
        
        try {

            boolean existedUser = userRepository.existsByEmail(email);
            if(!existedUser) return MembershipWithdrawalResposneDto.notExistUser();

            userRepository.deleteByEmail(email);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();   
        }
        return MembershipWithdrawalResposneDto.success();
    }
    
}
