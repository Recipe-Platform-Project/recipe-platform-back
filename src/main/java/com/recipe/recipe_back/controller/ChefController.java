package com.recipe.recipe_back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.recipe_back.dto.response.chef.GetChefListResponseDto;
import com.recipe.recipe_back.dto.response.chef.GetChefRankingResponseDto;
import com.recipe.recipe_back.dto.response.chef.GetChefSearchListResponseDto;
import com.recipe.recipe_back.service.ChefService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/chef")
@RequiredArgsConstructor
public class ChefController {

    public final ChefService chefService;

    @GetMapping("/list")
    public ResponseEntity<? super GetChefListResponseDto> getChefList() {
        ResponseEntity<? super GetChefListResponseDto> response = chefService.getChefList();
        return response;
    }

    @GetMapping("")
    public ResponseEntity<? super GetChefRankingResponseDto> getChefRanking(
        @PathVariable("selected") String selected
    ) {
        ResponseEntity<? super GetChefRankingResponseDto> response = chefService.getChefRanking(selected);
        return response;
    }

    @GetMapping("/{searchNickname}")
    public ResponseEntity<? super GetChefSearchListResponseDto> getChefSearchList(
        @PathVariable(value = "searchNickname") String searchNickname
    ) {
        ResponseEntity<? super GetChefSearchListResponseDto> response = chefService.getChefSearchList(searchNickname);
        return response;
    }
}
