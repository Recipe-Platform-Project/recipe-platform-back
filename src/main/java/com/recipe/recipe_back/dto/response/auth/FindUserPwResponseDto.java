package com.recipe.recipe_back.dto.response.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.dto.response.ResponseCode;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.ResponseMessage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class FindUserPwResponseDto extends ResponseDto{
    
    private String updatePassword;

    private FindUserPwResponseDto(String code, String message){
        super(code, message);
    }

    public static ResponseEntity<FindUserPwResponseDto> success(String updatePassword){
        FindUserPwResponseDto result = new FindUserPwResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        result.updatePassword = updatePassword;
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<FindUserPwResponseDto> findUserFailed(){
        FindUserPwResponseDto result = new FindUserPwResponseDto(ResponseCode.FIND_USER_FAILED, ResponseMessage.FIND_USER_FAILED);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

}
