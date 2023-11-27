package com.recipe.recipe_back.dto.response.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.dto.response.ResponseCode;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.ResponseMessage;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
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
    
    public static ResponseEntity<ResponseDto> findUserFailed(){
        ResponseDto result = new ResponseDto(ResponseCode.FIND_USER_FAILED, ResponseMessage.FIND_USER_FAILED);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public String getEmail(){
        return email;
    }

}
