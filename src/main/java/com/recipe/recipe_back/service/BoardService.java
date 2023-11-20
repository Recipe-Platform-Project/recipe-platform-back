package com.recipe.recipe_back.service;

import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.dto.response.board.GetCatagorySearchBoardListResponseDto;
import com.recipe.recipe_back.dto.response.board.GetRankingBoardListResponseDto;

public interface BoardService {
    ResponseEntity<? super GetCatagorySearchBoardListResponseDto> getCatagorySearchBoardList(String searchWord, String type, String way, String material);
    ResponseEntity<? super GetRankingBoardListResponseDto> getRankingBoardList(String selected, String times);
}
