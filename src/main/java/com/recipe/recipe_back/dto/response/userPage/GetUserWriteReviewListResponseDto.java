package com.recipe.recipe_back.dto.response.userPage;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.common.object.UserReviewListItem;
import com.recipe.recipe_back.dto.response.ResponseCode;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.ResponseMessage;
import com.recipe.recipe_back.repository.resultSet.UserReviewListResultSet;

import lombok.Getter;

@Getter
public class GetUserWriteReviewListResponseDto extends ResponseDto { 
    
    private List<UserReviewListItem> latestList;

    private GetUserWriteReviewListResponseDto(String code, String message, List<UserReviewListResultSet> resultSets){
        super(code, message);
        this.latestList = UserReviewListItem.getList(resultSets);
    }

    public static ResponseEntity<GetUserWriteReviewListResponseDto> success(List<UserReviewListResultSet> resultSets) {
        GetUserWriteReviewListResponseDto result = new GetUserWriteReviewListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
