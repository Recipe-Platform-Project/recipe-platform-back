package com.recipe.recipe_back.service;

import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.dto.response.chef.GetChefListResponseDto;
import com.recipe.recipe_back.dto.response.chef.GetChefRankingResponseDto;
import com.recipe.recipe_back.dto.response.chef.GetChefSearchListResponseDto;

public interface ChefService {

    ResponseEntity<? super GetChefListResponseDto> getChefList(String email);

    ResponseEntity<? super GetChefRankingResponseDto> getChefRanking(String email);

    ResponseEntity<? super GetChefSearchListResponseDto> getChefSearchList(String email);
}
