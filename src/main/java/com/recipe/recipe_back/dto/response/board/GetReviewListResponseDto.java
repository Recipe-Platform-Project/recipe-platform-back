package com.recipe.recipe_back.dto.response.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.common.object.ReviewListItem;
import com.recipe.recipe_back.dto.response.ResponseCode;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.ResponseMessage;
import com.recipe.recipe_back.repository.resultSet.ReviewListResultSet;

import lombok.Getter;

@Getter
public class GetReviewListResponseDto extends ResponseDto{

    List<ReviewListItem> reviewList;
    
    public GetReviewListResponseDto(String code, String Message, List<ReviewListResultSet> resultSets){
        super(code, Message);
        this.reviewList = ReviewListItem.getList(resultSets);
    }

    public static ResponseEntity<GetReviewListResponseDto> success(List<ReviewListResultSet> resultSets){
        GetReviewListResponseDto result = new GetReviewListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistBoard() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_BOARD, ResponseMessage.NOT_EXIST_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
