package com.recipe.recipe_back.dto.response.board;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.dto.response.ResponseCode;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class PatchCommentResponseDto extends ResponseDto{

    private PatchCommentResponseDto(String code, String message){
        super(code, message);
    }

    public static ResponseEntity<PatchCommentResponseDto> success() {
        PatchCommentResponseDto result = new PatchCommentResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser(){
        ResponseDto result = new PatchCommentResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistBoard(){
        ResponseDto result = new PatchCommentResponseDto(ResponseCode.NOT_EXIST_BOARD, ResponseMessage.NOT_EXIST_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    
    public static ResponseEntity<ResponseDto> notExistComment(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_COMMENT, ResponseMessage.NOT_EXIST_COMMENT);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> noPermission(){
        ResponseDto result = new ResponseDto(ResponseCode.NO_PERMISSION, ResponseMessage.NO_PERMISSION);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(result);
    }
}