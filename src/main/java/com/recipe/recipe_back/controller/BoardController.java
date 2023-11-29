package com.recipe.recipe_back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.recipe_back.dto.response.board.GetCatagorySearchBoardListResponseDto;
import com.recipe.recipe_back.dto.response.board.GetRankingBoardListResponseDto;

import javax.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.recipe.recipe_back.dto.response.board.GetNewBoardListResponseDto;
import com.recipe.recipe_back.dto.response.board.PatchCommentResponseDto;
import com.recipe.recipe_back.dto.response.board.PostCommentResponseDto;
import com.recipe.recipe_back.dto.response.board.PostReviewResponseDto;
import com.recipe.recipe_back.dto.request.board.PatchCommentRequestDto;
import com.recipe.recipe_back.dto.request.board.PatchReviewRequestDto;
import com.recipe.recipe_back.dto.request.board.PostCommentRequestDto;
import com.recipe.recipe_back.dto.request.board.PostReviewRequestDto;
import com.recipe.recipe_back.dto.response.board.PatchReviewResponseDto;
import com.recipe.recipe_back.dto.response.board.DeleteCommentResponseDto;
import com.recipe.recipe_back.dto.response.board.DeleteReviewResponseDto;
import com.recipe.recipe_back.dto.response.board.GetBestRecipeListResponseDto;
import com.recipe.recipe_back.dto.response.board.GetCategoryCommendBoardListResponseDto;
import com.recipe.recipe_back.dto.response.board.GetCommentListResponseDto;
import com.recipe.recipe_back.dto.response.board.GetReviewListResponseDto;
import com.recipe.recipe_back.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/board")
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

    @GetMapping("/best-3")
    public ResponseEntity<? super GetBestRecipeListResponseDto> getBestRecipeList() {
        ResponseEntity<? super GetBestRecipeListResponseDto> response = boardService.getBestRecipeList();
        return response;
    }

    @GetMapping("/new-list")
    public ResponseEntity<? super GetNewBoardListResponseDto> getNewList() {
        ResponseEntity<? super GetNewBoardListResponseDto> response = boardService.getNewBoardList();
        return response;
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<? super GetCategoryCommendBoardListResponseDto> getCategoryCommendBoardList(
        @PathVariable("category") String category) {
        ResponseEntity<? super GetCategoryCommendBoardListResponseDto> response = boardService.getCategoryCommendBoardList(category);
        return response;
    }

    @GetMapping("/{boardNumber}/comment-list")
    public ResponseEntity<? super GetCommentListResponseDto> getCommentList(
            @PathVariable("boardNumber") Integer boardNumber){
        ResponseEntity<? super GetCommentListResponseDto> response = boardService.getCommentList(boardNumber);
        return response;
        }

        
    @PostMapping("/{boardNumber}/comment")
    public ResponseEntity<? super PostCommentResponseDto> postComment(
            @RequestBody @Valid PostCommentRequestDto requestBody,
            @PathVariable("boardNumber") Integer boardNumber,
            @AuthenticationPrincipal String email){
        ResponseEntity<? super PostCommentResponseDto> response = boardService.postComment(requestBody, boardNumber, email);
        return response;
    }

    @PatchMapping("/{boardNumber}/comment/{commentNumber}")
    public ResponseEntity<? super PatchCommentResponseDto> patchComment(
        @RequestBody @Valid PatchCommentRequestDto requestBody,
        @PathVariable("boardNumber") Integer boardNumber,
        @PathVariable("commentNumber") Integer commentNumber,
        @AuthenticationPrincipal String email){
            ResponseEntity<? super PatchCommentResponseDto> response = boardService.patchComment(requestBody, boardNumber, commentNumber, email);
            return response;
    }    
    
    @DeleteMapping("/{boardNumber}/comment/{commentNumber}")
    public ResponseEntity<? super DeleteCommentResponseDto> deleteComment(
        @PathVariable("boardNumber") Integer boardNumber,
        @PathVariable("commentNumber") Integer commentNumber,
        @AuthenticationPrincipal String email){
            ResponseEntity<? super DeleteCommentResponseDto> response = boardService.deleteComment(boardNumber, commentNumber, email);
            return response;
        }
    
    @PostMapping("/{boardNumber}/review")
    public ResponseEntity<? super PostReviewResponseDto> postReview(
        @RequestBody @Valid PostReviewRequestDto requestBody,
        @PathVariable("boardNumber") Integer boardNumber,
        @AuthenticationPrincipal String email){
            ResponseEntity<? super PostReviewResponseDto> response = boardService.postReview(requestBody, boardNumber, email);
            return response;
        }
    @PatchMapping("/{boardNumber}/review/{commentNumber}")
    public ResponseEntity<? super PatchReviewResponseDto> patchReview(
        @RequestBody @Valid PatchReviewRequestDto requestBody,
        @PathVariable("boardNumber") Integer boardNumber,
        @PathVariable("commentNumber") Integer commentNumber,
        @AuthenticationPrincipal String email){
            ResponseEntity<? super PatchReviewResponseDto> response = boardService.patchReview(requestBody, boardNumber, commentNumber, email);
            return response;
    } 
    
    @GetMapping("/{boardNumber}/review-list")
    public ResponseEntity<? super GetReviewListResponseDto> getReviewList(
            @PathVariable("boardNumber") Integer boardNumber){
        ResponseEntity<? super GetReviewListResponseDto> response = boardService.getReviewList(boardNumber);
        return response;
        }

    @DeleteMapping("/{boardNumber}/review/{commentNumber}")
    public ResponseEntity<? super DeleteReviewResponseDto> deleteReview(
        @PathVariable("boardNumber") Integer boardNumber,
        @PathVariable("commentNumber") Integer commentNumber,
        @AuthenticationPrincipal String email){
            ResponseEntity<? super DeleteReviewResponseDto> response = boardService.deleteReview(boardNumber, commentNumber, email);
            return response;
        }
}
