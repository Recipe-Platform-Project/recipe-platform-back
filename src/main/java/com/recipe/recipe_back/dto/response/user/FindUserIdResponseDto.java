package com.recipe.recipe_back.dto.response.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.dto.response.ResponseCode;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.ResponseMessage;

public class FindUserIdResponseDto extends ResponseDto{

    private String email;

    private FindUserIdResponseDto(String code, String message, String email){
        super(code, message);
        this.email = email;
    }

    public static ResponseEntity<FindUserIdResponseDto> success(String email){
        FindUserIdResponseDto result = new FindUserIdResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, email);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
    public static ResponseEntity<FindUserIdResponseDto> findUserFailed(){
        FindUserIdResponseDto result = new FindUserIdResponseDto(ResponseCode.FIND_USER_FAILED, ResponseMessage.FIND_USER_FAILED, null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public String getEmail(){
        return email;
    }

}
