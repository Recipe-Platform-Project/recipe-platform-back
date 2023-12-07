package com.recipe.recipe_back.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.recipe.recipe_back.dto.request.board.PatchCommentRequestDto;
import com.recipe.recipe_back.dto.request.board.PatchReviewRequestDto;
import com.recipe.recipe_back.dto.request.board.PostCommentRequestDto;
import com.recipe.recipe_back.dto.request.board.PostRecipeWriteSequenceRequestDto;
import com.recipe.recipe_back.dto.request.board.PostReviewRequestDto;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.board.DeleteCommentResponseDto;
import com.recipe.recipe_back.dto.response.board.DeleteReviewResponseDto;
import com.recipe.recipe_back.dto.response.board.GetBestRecipeListResponseDto;
import com.recipe.recipe_back.dto.response.board.GetCategoryCommendBoardListResponseDto;
import com.recipe.recipe_back.dto.response.board.GetCommentListResponseDto;
import com.recipe.recipe_back.dto.response.board.GetNewBoardListResponseDto;
import com.recipe.recipe_back.dto.response.board.PatchCommentResponseDto;
import com.recipe.recipe_back.dto.response.board.PatchReviewResponseDto;
import com.recipe.recipe_back.dto.response.board.PostCommentResponseDto;
import com.recipe.recipe_back.dto.response.board.PostReviewResponseDto;
import com.recipe.recipe_back.dto.response.board.GetReviewListResponseDto;
import com.recipe.recipe_back.entity.BoardEntity;
import com.recipe.recipe_back.entity.BoardViewEntity;
import com.recipe.recipe_back.entity.CommentEntity;
import com.recipe.recipe_back.entity.RecipeWriteSequenceEntity;
import com.recipe.recipe_back.entity.ReviewEntity;
import com.recipe.recipe_back.repository.BoardRepository;
import com.recipe.recipe_back.repository.BoardViewRepository;
import com.recipe.recipe_back.repository.CommentRepository;
import com.recipe.recipe_back.repository.ReviewRepository;
import com.recipe.recipe_back.repository.UserRepository;
import com.recipe.recipe_back.repository.resultSet.CommentListResultSet;
import com.recipe.recipe_back.repository.resultSet.ReviewListResultSet;
import com.recipe.recipe_back.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImplement implements BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final ReviewRepository reviewRepository;
    private final CommentRepository commentRepository;
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

    @Override
    public ResponseEntity<? super GetNewBoardListResponseDto> getNewBoardList() {

        List<BoardViewEntity> boardViewEntities = new ArrayList<>();

        try {

            boardViewEntities = boardViewRepository.findTop12ByOrderByWriteDatetimeDesc();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetNewBoardListResponseDto.success(boardViewEntities);
    }

    @Override
    public ResponseEntity<? super GetCategoryCommendBoardListResponseDto> getCategoryCommendBoardList(String category) {

        List<BoardViewEntity> boardViewEntities = new ArrayList<>();

        try {

            boardViewEntities = boardViewRepository.findTop12ByKindCategoryOrderByFavoriteCountDesc(category);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetCategoryCommendBoardListResponseDto.success(boardViewEntities);
    }

    @Override
    public ResponseEntity<? super PostCommentResponseDto> postComment(PostCommentRequestDto dto, Integer boardNumber,
            String email) {
                try {
                    
                    BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
                    if (boardEntity == null) return PostCommentResponseDto.notExistBoard();

                    boolean existedUser = userRepository.existsByEmail(email);
                    if (!existedUser) return PostCommentResponseDto.notExistUser();

                    CommentEntity commentEntity = new CommentEntity(dto, boardNumber, email);
                    commentRepository.save(commentEntity);

                    boardEntity.increaseCommentCount();
                    boardRepository.save(boardEntity);

                } catch (Exception exception) {
                    exception.printStackTrace();
                    return ResponseDto.databaseError();
                }
                return PostCommentResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchCommentResponseDto> patchComment(PatchCommentRequestDto dto, Integer boardNumber, Integer commentNumber,
            String email) {
                try {
                    
                    BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
                    if (boardEntity == null) return PatchCommentResponseDto.notExistBoard();

                    boolean existedUser = userRepository.existsByEmail(email);
                    if (!existedUser) return PatchCommentResponseDto.notExistUser();

                    CommentEntity commentEntity = commentRepository.findByCommentNumber(commentNumber);
                    if (commentEntity == null) return PatchCommentResponseDto.notExistComment();

                    boolean equalWriter = commentEntity.getUserEmail().equals(email);
                    if (!equalWriter)
                        return PatchCommentResponseDto.noPermission();

                    commentEntity.patch(dto);
                    commentRepository.save(commentEntity);

                } catch (Exception exception) {
                    exception.printStackTrace();
                    return ResponseDto.databaseError();
                }
                return PatchCommentResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer boardNumber) {
        
        List<CommentListResultSet> resultSets = new ArrayList<>();

        try {

            boolean existedBoard = boardRepository.existsByBoardNumber(boardNumber);
            if (!existedBoard)
                return GetCommentListResponseDto.notExistBoard();

            resultSets = commentRepository.findByCommentList(boardNumber);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetCommentListResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super DeleteCommentResponseDto> deleteComment(Integer boardNumber, Integer commentNumber,
            String email) {
                try {
                    
                    BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
                    if (boardEntity == null) return DeleteCommentResponseDto.notExistBoard();

                    boolean existedUser = userRepository.existsByEmail(email);
                    if (!existedUser) return DeleteCommentResponseDto.notExistUser();

                    CommentEntity commentEntity = commentRepository.findByCommentNumber(commentNumber);
                    if (commentEntity == null) return DeleteCommentResponseDto.notExistComment();

                    boolean equalWriter = commentEntity.getUserEmail().equals(email);
                    if (!equalWriter) return DeleteCommentResponseDto.noPermission();

                    // replyCommentRepository.deleteByCommentNumbet(commentNumber);
                    commentRepository.delete(commentEntity);
                    
                } catch (Exception exception) {
                    exception.printStackTrace();
                    return ResponseDto.databaseError();
                }

                return DeleteCommentResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PostReviewResponseDto> postReview(PostReviewRequestDto dto, Integer boardNumber,
            String email) {
                try {
                    
                    BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
                    if (boardEntity == null) return PostReviewResponseDto.notExistBoard();

                    boolean existedUser = userRepository.existsByEmail(email);
                    if (!existedUser) return PostReviewResponseDto.notExistUser();

                    ReviewEntity reviewEntity = new ReviewEntity(dto, boardNumber, email);
                    reviewRepository.save(reviewEntity);

                    // boardEntity.increaseCommentCount();
                    // boardRepository.save(boardEntity);

                } catch (Exception exception) {
                    exception.printStackTrace();
                    return ResponseDto.databaseError();
                }
                return PostReviewResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchReviewResponseDto> patchReview(PatchReviewRequestDto dto, Integer boardNumber,
            Integer commentNumber, String email) {
                try {
                    
                    BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
                    if (boardEntity == null) return PatchReviewResponseDto.notExistBoard();

                    boolean existedUser = userRepository.existsByEmail(email);
                    if (!existedUser) return PatchReviewResponseDto.notExistUser();

                    ReviewEntity reviewEntity = reviewRepository.findByCommentNumber(commentNumber);
                    if (reviewEntity == null) return PatchReviewResponseDto.notExistComment();

                    boolean equalWriter = reviewEntity.getUserEmail().equals(email);
                    if (!equalWriter)
                        return PatchCommentResponseDto.noPermission();

                    reviewEntity.patch(dto);
                    reviewRepository.save(reviewEntity);

                } catch (Exception exception) {
                    exception.printStackTrace();
                    return ResponseDto.databaseError();
                }
                return PatchReviewResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetReviewListResponseDto> getReviewList(Integer boardNumber) {
        
        List<ReviewListResultSet> resultSets = new ArrayList<>();

        try {

            boolean existedBoard = boardRepository.existsByBoardNumber(boardNumber);
            if (!existedBoard)
                return GetReviewListResponseDto.notExistBoard();

            resultSets = reviewRepository.findByReviewList(boardNumber);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetReviewListResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super DeleteReviewResponseDto> deleteReview(Integer boardNumber, Integer commentNumber,
            String email) {
                try {
                    
                    BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
                    if (boardEntity == null) return DeleteReviewResponseDto.notExistBoard();

                    boolean existedUser = userRepository.existsByEmail(email);
                    if (!existedUser) return DeleteReviewResponseDto.notExistUser();

                    ReviewEntity reviewEntity = reviewRepository.findByCommentNumber(commentNumber);
                    if (reviewEntity == null) return DeleteReviewResponseDto.notExistComment();

                    boolean equalWriter = reviewEntity.getUserEmail().equals(email);
                    if (!equalWriter) return DeleteReviewResponseDto.noPermission();

                    // replyReviewRepository.deleteByCommentNumbet(commentNumber);
                    reviewRepository.delete(reviewEntity);
                    
                } catch (Exception exception) {
                    exception.printStackTrace();
                    return ResponseDto.databaseError();
                }

                return DeleteReviewResponseDto.success();
    }

    


}
