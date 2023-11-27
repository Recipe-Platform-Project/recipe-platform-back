package com.recipe.recipe_back.dto.response.userPage;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.common.object.UserRepleCommentListItem;
import com.recipe.recipe_back.dto.response.ResponseCode;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.ResponseMessage;
import com.recipe.recipe_back.repository.resultSet.UserRepleCommentListResultSet;

import lombok.Getter;

@Getter
public class GetUserRepleCommentResponseDto extends ResponseDto {

    List<UserRepleCommentListItem> userRepleCommentList;

    private GetUserRepleCommentResponseDto(String code, String message, List<UserRepleCommentListResultSet> resultSets) {
        super(code, message);
        this.userRepleCommentList = UserRepleCommentListItem.getList(resultSets);
    }

    public static ResponseEntity<GetUserRepleCommentResponseDto> success(List<UserRepleCommentListResultSet> resultSets) {
        GetUserRepleCommentResponseDto result = new GetUserRepleCommentResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistBoard() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_BOARD, ResponseMessage.NOT_EXIST_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
