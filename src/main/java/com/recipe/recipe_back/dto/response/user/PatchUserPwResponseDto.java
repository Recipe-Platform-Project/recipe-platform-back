package com.recipe.recipe_back.dto.response.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.dto.response.ResponseCode;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class PatchUserPwResponseDto extends ResponseDto{
    
    private PatchUserPwResponseDto(String code, String message){
        super(code, message);
    }

    public static ResponseEntity<PatchUserPwResponseDto> success(){
        PatchUserPwResponseDto result = new PatchUserPwResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> samePassword(){
        ResponseDto result = new ResponseDto(ResponseCode.SAME_PASSWORD, ResponseMessage.SAME_PASSWORD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> passwordMissMatch(){
        ResponseDto result = new ResponseDto(ResponseCode.PASSWORD_MISSMATCH, ResponseMessage.PASSWORD_MISSMATCH);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

}
