package com.recipe.recipe_back.service;

import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.dto.response.chef.GetChefListResponseDto;
import com.recipe.recipe_back.dto.response.chef.GetChefRankingResponseDto;
import com.recipe.recipe_back.dto.response.chef.GetChefSearchListResponseDto;
import com.recipe.recipe_back.dto.response.chef.GetTop30ChefListResponseDto;

public interface ChefService {

    ResponseEntity<? super GetChefListResponseDto> getChefList();

    ResponseEntity<? super GetChefRankingResponseDto> getChefRanking(String selected);

    ResponseEntity<? super GetChefSearchListResponseDto> getChefSearchList(String searchNickname);

    ResponseEntity<? super GetTop30ChefListResponseDto> getTop30ChefList();
}
