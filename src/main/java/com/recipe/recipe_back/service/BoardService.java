package com.recipe.recipe_back.service;

import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.dto.request.board.PatchCommentRequestDto;
import com.recipe.recipe_back.dto.request.board.PatchReviewRequestDto;
import com.recipe.recipe_back.dto.request.board.PostCommentRequestDto;
import com.recipe.recipe_back.dto.request.board.PostRecipeWriteSequenceRequestDto;
import com.recipe.recipe_back.dto.request.board.PostReviewRequestDto;
import com.recipe.recipe_back.dto.response.board.GetBestRecipeListResponseDto;
import com.recipe.recipe_back.dto.response.board.GetCategoryCommendBoardListResponseDto;
import com.recipe.recipe_back.dto.response.board.GetCommentListResponseDto;
import com.recipe.recipe_back.dto.response.board.GetNewBoardListResponseDto;
import com.recipe.recipe_back.dto.response.board.GetReviewListResponseDto;
import com.recipe.recipe_back.dto.response.board.PatchCommentResponseDto;
import com.recipe.recipe_back.dto.response.board.PostCommentResponseDto;
import com.recipe.recipe_back.dto.response.board.PostReviewResponseDto;
import com.recipe.recipe_back.dto.response.board.DeleteCommentResponseDto;
import com.recipe.recipe_back.dto.response.board.DeleteReviewResponseDto;
import com.recipe.recipe_back.dto.response.board.PatchReviewResponseDto;

public interface BoardService {
    
    ResponseEntity<? super PostCommentResponseDto> postComment(PostCommentRequestDto dto, Integer boardNumber, String email);
    ResponseEntity<? super PostReviewResponseDto> postReview(PostReviewRequestDto dto, Integer boardNumber, String email);

    ResponseEntity<? super GetBestRecipeListResponseDto> getBestRecipeList();
    ResponseEntity<? super GetNewBoardListResponseDto> getNewBoardList();
    ResponseEntity<? super GetCategoryCommendBoardListResponseDto> getCategoryCommendBoardList(String category);

    ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer boardNumber);
    ResponseEntity<? super GetReviewListResponseDto> getReviewList(Integer boardNumber);

    ResponseEntity<? super PatchCommentResponseDto> patchComment(PatchCommentRequestDto dto, Integer boardNumber, Integer commentNumber, String email);
    ResponseEntity<? super PatchReviewResponseDto> patchReview(PatchReviewRequestDto dto, Integer boardNumber, Integer commentNumber, String email);

    ResponseEntity<? super DeleteCommentResponseDto> deleteComment(Integer boardNumber, Integer commentNumber, String email);
    ResponseEntity<? super DeleteReviewResponseDto> deleteReview(Integer boardNumber, Integer commentNumber, String email);
}
