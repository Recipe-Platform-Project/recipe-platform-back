package com.recipe.recipe_back.dto.response.userPage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.dto.response.ResponseCode;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class PatchProfileCommentResponseDto extends ResponseDto {
    
    private PatchProfileCommentResponseDto(String code, String message) {
        super(code, message);
    }

    public static ResponseEntity<PatchProfileCommentResponseDto> success() {
        PatchProfileCommentResponseDto result = new PatchProfileCommentResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
