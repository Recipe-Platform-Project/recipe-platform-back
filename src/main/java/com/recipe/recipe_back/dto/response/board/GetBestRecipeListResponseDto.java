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
public class GetBestRecipeListResponseDto extends ResponseDto{

    private List<BoardListItem> bestList;

    private GetBestRecipeListResponseDto(String Code, String Message, List<BoardViewEntity> boardViewEntities){
        super(Code, Message);
        this.bestList = BoardListItem.getList(boardViewEntities);
    }

    public static ResponseEntity<GetBestRecipeListResponseDto> success(List<BoardViewEntity> boardViewEntities){
        GetBestRecipeListResponseDto result = new GetBestRecipeListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, boardViewEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
