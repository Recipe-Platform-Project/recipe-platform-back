package com.recipe.recipe_back.dto.response.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.common.object.CommentListItem;
import com.recipe.recipe_back.dto.response.ResponseCode;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.ResponseMessage;
import com.recipe.recipe_back.repository.resultSet.CommentListResultSet;

import lombok.Getter;

@Getter
public class GetCommentListResponseDto extends ResponseDto{
    
    List<CommentListItem> commentList;

    public GetCommentListResponseDto(String code, String Message, List<CommentListResultSet> resultSets){
        super(code, Message);
        this.commentList = CommentListItem.getList(resultSets);
    }

    public static ResponseEntity<GetCommentListResponseDto> success(List<CommentListResultSet> resultSets){
        GetCommentListResponseDto result = new GetCommentListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistBoard() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_BOARD, ResponseMessage.NOT_EXIST_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
