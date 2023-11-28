package com.recipe.recipe_back.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.chef.GetChefListResponseDto;
import com.recipe.recipe_back.dto.response.chef.GetChefRankingResponseDto;
import com.recipe.recipe_back.dto.response.chef.GetChefSearchListResponseDto;
import com.recipe.recipe_back.repository.ChefRepository;
import com.recipe.recipe_back.repository.resultSet.ChefListResultSet;
import com.recipe.recipe_back.service.ChefService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChefServiceImplement implements ChefService{
    
    private static final String email = null;
    private final ChefRepository chefRepository;

    @Override
    public ResponseEntity<? super GetChefListResponseDto> getChefList() {

        List<ChefListResultSet> resultSets = new ArrayList<>();

        try {
            
            resultSets = chefRepository.findeByChefList();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetChefListResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super GetChefRankingResponseDto> getChefRanking(String selected) {

        List<ChefListResultSet> resultSets = new ArrayList<>();

        try {
            // resultSets = chefRepository.findeByChefRanking();

            if (selected.equals("Ranking"))
                resultSets = chefRepository.findeByChefRanking();
            if (selected.equals("Like"))
                resultSets = chefRepository.findeByChefRankingLike();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetChefRankingResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super GetChefSearchListResponseDto> getChefSearchList(String searchNickname) {
     
        List<ChefListResultSet> resultSets = new ArrayList<>();

        try {
            boolean existedChef = chefRepository.existsByNickname(email);
            if (!existedChef) return GetChefSearchListResponseDto.notExistUser();

            resultSets = chefRepository.findeByChefSearchList(searchNickname);
        
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetChefSearchListResponseDto.success(resultSets);

    }
    
}
