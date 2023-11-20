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
public class GetSignInUserRecipeResponseDto extends ResponseDto {

    private List<UserRecipeListItem> signInUserRecipeList;

    private GetSignInUserRecipeResponseDto (String code, String message, List<BoardEntity> boardEntities, List<UserEntity> userEntities) {
        super(code, message);
        this.signInUserRecipeList = UserRecipeListItem.getList(boardEntities, userEntities);
    }

    public static ResponseEntity<GetSignInUserRecipeResponseDto> success(List<BoardEntity> boardEntities, List<UserEntity> userEntities) {
        GetSignInUserRecipeResponseDto result = new GetSignInUserRecipeResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, boardEntities, userEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistBoard() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_BOARD, ResponseMessage.NOT_EXIST_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
