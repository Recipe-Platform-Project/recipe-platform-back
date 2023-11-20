package com.recipe.recipe_back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.recipe_back.dto.response.board.GetBestRecipeListResponseDto;
import com.recipe.recipe_back.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {
    
    private final BoardService boardService;

    @GetMapping("/best-3")
    public ResponseEntity<? super GetBestRecipeListResponseDto> getBestRecipeList() {
        ResponseEntity<? super GetBestRecipeListResponseDto> response = boardService.getBestRecipeList();
        return response;
    }
}
