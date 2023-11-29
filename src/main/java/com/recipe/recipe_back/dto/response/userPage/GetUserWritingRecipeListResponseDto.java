package com.recipe.recipe_back.dto.response.userPage;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.common.object.UserReviewListItem;
import com.recipe.recipe_back.common.object.UserWritingRecipeListItem;
import com.recipe.recipe_back.dto.response.ResponseCode;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.ResponseMessage;
import com.recipe.recipe_back.entity.BoardEntity;
import com.recipe.recipe_back.repository.resultSet.UserWritingRecipeListResultSet;

import lombok.Getter;

@Getter
public class GetUserWritingRecipeListResponseDto extends ResponseDto {

    private List<UserWritingRecipeListItem> userWritingRecipeList;

    private GetUserWritingRecipeListResponseDto(String code, String message, List<UserWritingRecipeListResultSet> resultSets) {
        super(code, message);
        this.userWritingRecipeList = UserWritingRecipeListItem.getList(resultSets);
    }

    public static ResponseEntity<GetUserWritingRecipeListResponseDto> success(List<UserWritingRecipeListResultSet> resultSets) {
        GetUserWritingRecipeListResponseDto result = new GetUserWritingRecipeListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
