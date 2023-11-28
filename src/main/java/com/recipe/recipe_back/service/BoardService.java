package com.recipe.recipe_back.service;

import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.common.object.RecipeWriteSequenceItem;
import com.recipe.recipe_back.dto.request.board.PostBoardRequestDto;
import com.recipe.recipe_back.dto.response.board.PostBoardResponseDto;
import com.recipe.recipe_back.dto.response.board.PutFavoriteResponseDto;

public interface BoardService {

    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, RecipeWriteSequenceItem item,
            String email);

    ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email);
}
