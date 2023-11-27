package com.recipe.recipe_back.dto.response.userPage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.dto.response.ResponseCode;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.ResponseMessage;
import com.recipe.recipe_back.entity.BoardEntity;

import lombok.Getter;

@Getter
public class GetUserRecipeResponseDto extends ResponseDto {
    private int boardNumber;
    private String title;
    private String nickname;
    private String boardMainImage;
    
    private GetUserRecipeResponseDto(String code, String message, BoardEntity boardEntity) {
        super(code, message);

        this.boardNumber = boardEntity.getBoardNumber();
        this.title = boardEntity.getTitle();
        this.boardMainImage = boardEntity.getBoardMainImage();
    }

    public static ResponseEntity<GetUserRecipeResponseDto> success(BoardEntity boardEntity) {
        GetUserRecipeResponseDto result = new GetUserRecipeResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, boardEntity);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistBoard() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_BOARD, ResponseMessage.NOT_EXIST_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
