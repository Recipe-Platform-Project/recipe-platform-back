package com.recipe.recipe_back.service;

import org.springframework.http.ResponseEntity;
import com.recipe.recipe_back.dto.response.board.GetBestRecipeListResponseDto;

public interface BoardService {
    
    ResponseEntity<? super GetBestRecipeListResponseDto> getBestRecipeList();
}
