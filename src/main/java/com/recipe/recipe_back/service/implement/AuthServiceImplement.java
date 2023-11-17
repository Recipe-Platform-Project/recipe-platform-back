package com.recipe.recipe_back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.recipe.recipe_back.dto.request.auth.FindUserIdRequestDto;
import com.recipe.recipe_back.dto.request.auth.FindUserPwRequestDto;
import com.recipe.recipe_back.dto.request.auth.SignInRequestDto;
import com.recipe.recipe_back.dto.request.auth.SignUpRequestDto;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.auth.FindUserIdResponseDto;
import com.recipe.recipe_back.dto.response.auth.FindUserPwResponseDto;
import com.recipe.recipe_back.dto.response.auth.SignInResponseDto;
import com.recipe.recipe_back.dto.response.auth.SignUpResponseDto;
import com.recipe.recipe_back.entity.UserEntity;
import com.recipe.recipe_back.provider.JwtProvider;
import com.recipe.recipe_back.repository.UserRepository;
import com.recipe.recipe_back.service.AuthService;
import com.recipe.recipe_back.service.EmailService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService{
    
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    private final EmailService emailService;
    
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto){

        try {
            
            String email = dto.getEmail();
            String nickname = dto.getNickname();
            String telNumber = dto.getTelNumber();
            
            boolean hasEmail = userRepository.existsByEmail(email);
            if(hasEmail) return SignUpResponseDto.duplicateEmail();

            boolean hasNickname = userRepository.existsByNickname(nickname);
            if(hasNickname) return SignUpResponseDto.duplicateNickname();

            boolean hasTelNumber = userRepository.existsByTelNumber(telNumber);
            if(hasTelNumber) return SignUpResponseDto.duplicateTelNumber();

            String password = dto.getPassword();
            String encodedPassword = passwordEncoder.encode(password);

            dto.setPassword(encodedPassword);

            UserEntity userEntity = new UserEntity(dto);
            userEntity.defaultProfileImage(dto.getProfileImageUrl());
            userRepository.save(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignUpResponseDto.success();
    }

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
        
        String token = null;

        try {

            String email = dto.getEmail();

            UserEntity userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return SignInResponseDto.signInFailed();

            String password = dto.getPassword();
            String encodedPassword = userEntity.getPassword();

            boolean isMatched = passwordEncoder.matches(password, encodedPassword);
            if(!isMatched) return SignInResponseDto.signInFailed();

            token = jwtProvider.create(email);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignInResponseDto.success(token);
    }

    @Override
    public ResponseEntity<? super FindUserIdResponseDto> findUserId(FindUserIdRequestDto dto) {
        
        String userEmail = null;

        try {
            
            String name = dto.getName();
            String telNumber = dto.getTelNumber();

            UserEntity userEntity = userRepository.findByNameAndTelNumber(name, telNumber);

            if(userEntity == null){
                return FindUserIdResponseDto.findUserFailed();
            }

            userEmail = userEntity.getEmail();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return FindUserIdResponseDto.success(userEmail);
    }

    @Override
    public ResponseEntity<? super FindUserPwResponseDto> findUserPw(FindUserPwRequestDto dto) {

        try {

            String name = dto.getName();
            String email = dto.getEmail();
            String memberPassword = generateSparePassword();

            UserEntity userEntity = userRepository.findByNameAndEmail(name, email);

            if(userEntity == null){
                return FindUserPwResponseDto.findUserFailed();                
            }

            userEntity.updatePassword(memberPassword);
            userRepository.save(userEntity);
            
            emailService.mailSend(email, memberPassword);

            return FindUserPwResponseDto.success(memberPassword);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    }

    private String generateSparePassword() {
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
                'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String sparePassword = "";
        int index = 0;

        // 문자 배열 길이의 값을 랜덤으로 10개를 뽑아 구문을 작성함
        for (int i = 0; i < 10; i++) {
            index = (int) (charSet.length * Math.random());
            sparePassword += charSet[index];
        }

        return sparePassword;
    }


}
