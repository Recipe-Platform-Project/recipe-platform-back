package com.recipe.recipe_back.dto.response.userPage;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.common.object.UserRecipeListItem;
import com.recipe.recipe_back.dto.response.ResponseCode;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.ResponseMessage;
import com.recipe.recipe_back.entity.BoardEntity;
import com.recipe.recipe_back.entity.UserEntity;

import lombok.Getter;

@Getter
public class GetUserRecipeResponseDto extends ResponseDto {
    
    private List<UserRecipeListItem> userRecipeList;

    private GetUserRecipeResponseDto(String code, String message, List<BoardEntity> boardEntities, List<UserEntity> userEntityes) {
        super(code, message);
        this.userRecipeList = UserRecipeListItem.getList(boardEntities, userEntityes);
    }

    public static ResponseEntity<GetUserRecipeResponseDto> success(List<BoardEntity> boardEntity, List<UserEntity> userEntity) {
        GetUserRecipeResponseDto result = new GetUserRecipeResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, boardEntity, userEntity);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistBoard() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_BOARD, ResponseMessage.NOT_EXIST_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
