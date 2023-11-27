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
public class GetUserReviewListResponseDto extends ResponseDto {

    private List<UserReviewListItem> latestList;

    private GetUserReviewListResponseDto(String code, String message, List<UserReviewListResultSet> resultSets){
        super(code, message);
        this.latestList = UserReviewListItem.getList(resultSets);
    }

    public static ResponseEntity<GetUserReviewListResponseDto> success(List<UserReviewListResultSet> resultSets) {
        GetUserReviewListResponseDto result = new GetUserReviewListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
