package com.recipe.recipe_back.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.board.GetBestRecipeListResponseDto;
import com.recipe.recipe_back.entity.BoardViewEntity;
import com.recipe.recipe_back.repository.BoardViewRepository;
import com.recipe.recipe_back.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImplement implements BoardService {


    private final BoardViewRepository boardViewRepository;

    @Override
    public ResponseEntity<? super GetBestRecipeListResponseDto> getBestRecipeList() {

        List<BoardViewEntity> boardViewEntities = new ArrayList<>();
        try {

            boardViewEntities = boardViewRepository.findTop3ByOrderByFavoriteCountDesc();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetBestRecipeListResponseDto.success(boardViewEntities);
    }
    
}
