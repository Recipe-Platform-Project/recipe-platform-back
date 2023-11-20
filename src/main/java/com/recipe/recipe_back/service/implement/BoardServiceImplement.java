package com.recipe.recipe_back.service.implement;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.board.GetCatagorySearchBoardListResponseDto;
import com.recipe.recipe_back.dto.response.board.GetRankingBoardListResponseDto;
import com.recipe.recipe_back.entity.BoardViewEntity;
import com.recipe.recipe_back.repository.BoardViewRepository;
import com.recipe.recipe_back.service.BoardService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class BoardServiceImplement implements BoardService{
    private final BoardViewRepository boardViewRepository;

    @Override
    public ResponseEntity<? super GetCatagorySearchBoardListResponseDto> getCatagorySearchBoardList(String searchWord, String kind, String way, String material) {

        List<BoardViewEntity> boardViewEntities = new ArrayList<>();

        searchWord = searchWord == null ? "" : searchWord;
        kind = kind.equals("전체") ? "" : kind;
        way = way.equals("전체") ? "" : way;
        material = material.equals("전체") ? "" : material;

        try {
            boardViewEntities = boardViewRepository.getCatagorySeachList(searchWord, kind, way, material);
        } catch (Exception exception) {
        exception.printStackTrace();
        return ResponseDto.databaseError();
        }
        return GetCatagorySearchBoardListResponseDto.sucess(boardViewEntities);
    }

    @Override
    public ResponseEntity<? super GetRankingBoardListResponseDto> getRankingBoardList(String selected, String times) {

        List<BoardViewEntity> boardViewEntities = new ArrayList<>();

        try{
            Date nowDate = Date.from(Instant.now());
            int amountToSubtract = times.equals("days") ? 24 :
                                    times.equals("weekly") ? 168 :
                                    times.equals("month") ? 672 : 0;
            Date compareDate = Date.from(Instant.now().minus(amountToSubtract, ChronoUnit.HOURS));

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String nowString = simpleDateFormat.format(nowDate);
            String comparString = simpleDateFormat.format(compareDate);

            if (selected.equals("best"))
                boardViewEntities = boardViewRepository.getRankingViewCountList(comparString, nowString);
            if (selected.equals("favorite"))
                boardViewEntities = boardViewRepository.getRankingViewCountList(comparString, nowString);
            if (selected.equals("view"))
                boardViewEntities = boardViewRepository.getRankingViewCountList(comparString, nowString);

        
        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetRankingBoardListResponseDto.success(boardViewEntities);


    }
}