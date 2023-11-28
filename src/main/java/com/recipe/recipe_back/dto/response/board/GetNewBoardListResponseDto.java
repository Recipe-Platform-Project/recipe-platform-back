package com.recipe.recipe_back.dto.response.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.common.object.BoardListItem;
import com.recipe.recipe_back.dto.response.ResponseCode;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.ResponseMessage;
import com.recipe.recipe_back.entity.BoardViewEntity;

import lombok.Getter;

@Getter
public class GetNewBoardListResponseDto extends ResponseDto{
    
    private List<BoardListItem> newList;

    private GetNewBoardListResponseDto(String code, String message, List<BoardViewEntity> boardViewEntities){
        super(code, message);
        this.newList = BoardListItem.getList(boardViewEntities);
    }

    public static ResponseEntity<GetNewBoardListResponseDto> success(List<BoardViewEntity> boardViewEntities){
        GetNewBoardListResponseDto result = new GetNewBoardListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, boardViewEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
