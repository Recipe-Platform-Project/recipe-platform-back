package com.recipe.recipe_back.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.chef.GetChefListResponseDto;
import com.recipe.recipe_back.dto.response.chef.GetChefRankingResponseDto;
import com.recipe.recipe_back.dto.response.chef.GetChefSearchListResponseDto;
import com.recipe.recipe_back.entity.BoardEntity;
import com.recipe.recipe_back.entity.UserEntity;
import com.recipe.recipe_back.repository.ChefRepository;
import com.recipe.recipe_back.service.ChefService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChefServiceImplement implements ChefService{
    
    private final ChefRepository chefRepository;

    @Override
    public ResponseEntity<? super GetChefListResponseDto> getChefList() {

        List<UserEntity> userEntities = new ArrayList<>();
        List<BoardEntity> boardEntities = new ArrayList<>();

        try {
            
            userEntities = chefRepository.findeByChefList();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetChefListResponseDto.success(userEntities, boardEntities);
    }

    @Override
    public ResponseEntity<? super GetChefRankingResponseDto> getChefRanking() {

        List<UserEntity> userEntities = new ArrayList<>();
        List<BoardEntity> boardEntities = new ArrayList<>();

        try {

            userEntities = chefRepository.findeByChefRanking();
        
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetChefRankingResponseDto.success(userEntities, boardEntities);
    }

    @Override
    public ResponseEntity<? super GetChefSearchListResponseDto> getChefSearchList(String searchNickname) {
     
        List<UserEntity> userEntities = new ArrayList<>();
        List<BoardEntity> boardEntities = new ArrayList<>();

        try {

            boolean existedChef = chefRepository.existsById(searchNickname);
            if (!existedChef) return GetChefSearchListResponseDto.notExistUser();

            userEntities = chefRepository.findeByChefSearchList(searchNickname);
        
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetChefSearchListResponseDto.success(userEntities, boardEntities);

    }
    
}
