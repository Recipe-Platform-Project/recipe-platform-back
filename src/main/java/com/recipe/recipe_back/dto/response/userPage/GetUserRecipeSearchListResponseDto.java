package com.recipe.recipe_back.dto.response.userPage;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.common.object.UserRecipeListItem;
import com.recipe.recipe_back.dto.response.ResponseCode;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.ResponseMessage;
import com.recipe.recipe_back.repository.resultSet.UserRecipeListResultSet;

import lombok.Getter;

@Getter
public class GetUserRecipeSearchListResponseDto extends ResponseDto {
    
    List<UserRecipeListItem> userRecipeSearchList;

    private GetUserRecipeSearchListResponseDto(String code, String message, List<UserRecipeListResultSet> resultSets) {
        super(code, message);
        this.userRecipeSearchList = UserRecipeListItem.getList(resultSets);
    }

    public static ResponseEntity<GetUserRecipeSearchListResponseDto> success(List<UserRecipeListResultSet> resultSets) {
        GetUserRecipeSearchListResponseDto result = new GetUserRecipeSearchListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistBoard() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_BOARD, ResponseMessage.NOT_EXIST_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
