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
public class GetCatagorySearchBoardListResponseDto extends ResponseDto{
    
    private List<BoardListItem> searchList;

    private GetCatagorySearchBoardListResponseDto(String code, String message, List<BoardViewEntity> boardViewEntities){
        super(code, message);
        this.searchList = BoardListItem.getList(boardViewEntities);
    }

    public static ResponseEntity<GetCatagorySearchBoardListResponseDto> sucess(List<BoardViewEntity> boardViewEntities) {
        GetCatagorySearchBoardListResponseDto result = new GetCatagorySearchBoardListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, boardViewEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistBoard() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_BOARD, ResponseMessage.NOT_EXIST_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
