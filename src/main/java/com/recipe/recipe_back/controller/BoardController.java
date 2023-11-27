package com.recipe.recipe_back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.recipe_back.dto.response.board.GetCatagorySearchBoardListResponseDto;
import com.recipe.recipe_back.dto.response.board.GetRankingBoardListResponseDto;
import com.recipe.recipe_back.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping(value={"/recipe-list/{searchWord}/{kind}/{way}/{material}", "/recipe-list/{kind}/{way}/{material}"})
    public ResponseEntity<? super GetCatagorySearchBoardListResponseDto> getCatagorySearchBoardList(
        @PathVariable(value="searchWord", required = false) String searchWord,
        @PathVariable("kind") String kind,
        @PathVariable("way") String way,
        @PathVariable("material") String material
    ){
        ResponseEntity<? super GetCatagorySearchBoardListResponseDto> response = boardService.getCatagorySearchBoardList(searchWord, kind, way, material);
        return response;
    }
    
    @GetMapping("/ranking/board-list/{selected}/{times}")
    public ResponseEntity<? super GetRankingBoardListResponseDto> getRankingBoardList(
        @PathVariable("selected") String selected,
        @PathVariable("times") String times
    ){
        ResponseEntity<? super GetRankingBoardListResponseDto> response = boardService.getRankingBoardList(selected, times);
        return response;
    }
}
