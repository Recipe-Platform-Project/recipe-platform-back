package com.recipe.recipe_back.dto.response.userPage;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.common.object.UserRecipeReviewListItem;
import com.recipe.recipe_back.dto.response.ResponseCode;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.ResponseMessage;
import com.recipe.recipe_back.entity.BoardEntity;
import com.recipe.recipe_back.entity.ReviewEntity;

import lombok.Getter;

@Getter
public class GetUserRecipeReviewListResponseDto extends ResponseDto {

    private List<UserRecipeReviewListItem> latestList;

    private GetUserRecipeReviewListResponseDto(String code, String message, List<BoardEntity> boardEntities, List<ReviewEntity> reviewEntities){
        super(code, message);
        this.latestList = UserRecipeReviewListItem.getList(boardEntities, reviewEntities);
    }

    public static ResponseEntity<GetUserRecipeReviewListResponseDto> success(List<BoardEntity> boardEntities, List<ReviewEntity> reviewEntities) {
        GetUserRecipeReviewListResponseDto result = new GetUserRecipeReviewListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, boardEntities, reviewEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
