package com.recipe.recipe_back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.recipe.recipe_back.dto.request.auth.FindUserIdRequestDto;
import com.recipe.recipe_back.dto.request.auth.SignInRequestDto;
import com.recipe.recipe_back.dto.request.auth.SignUpRequestDto;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.auth.SignInResponseDto;
import com.recipe.recipe_back.dto.response.auth.SignUpResponseDto;
import com.recipe.recipe_back.dto.response.user.FindUserIdResponseDto;
import com.recipe.recipe_back.entity.UserEntity;
import com.recipe.recipe_back.provider.JwtProvider;
import com.recipe.recipe_back.repository.UserRepository;
import com.recipe.recipe_back.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService{
    
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    
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
    public ResponseEntity<? super FindUserIdResponseDto> findeUserId(FindUserIdRequestDto dto) {
        
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
}
