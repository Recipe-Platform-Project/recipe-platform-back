package com.recipe.recipe_back.service;

import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.dto.response.chef.GetChefListResponseDto;
import com.recipe.recipe_back.dto.response.chef.GetChefRankingResponseDto;
import com.recipe.recipe_back.dto.response.chef.GetChefSearchListResponseDto;

public interface ChefService {

    ResponseEntity<? super GetChefListResponseDto> getChefList();

    ResponseEntity<? super GetChefRankingResponseDto> getChefRanking();

    ResponseEntity<? super GetChefSearchListResponseDto> getChefSearchList(String searchNickname);
}
