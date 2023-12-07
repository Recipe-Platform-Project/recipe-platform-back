package com.recipe.recipe_back.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.recipe.recipe_back.common.object.RecipeWriteSequenceItem;
// import com.recipe.recipe_back.common.object.MaterialCategoriesListItem;
// import com.recipe.recipe_back.common.object.MaterialListItem;
// import com.recipe.recipe_back.common.object.RecipeWriteSequenceListItem;
import com.recipe.recipe_back.dto.request.board.PostBoardRequestDto;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.board.PostBoardResponseDto;
import com.recipe.recipe_back.dto.response.board.PutFavoriteResponseDto;
import com.recipe.recipe_back.entity.BoardEntity;
import com.recipe.recipe_back.entity.CookingFinishImageEntity;
import com.recipe.recipe_back.entity.FavoriteEntity;
import com.recipe.recipe_back.entity.MaterialCategoriesEntity;
import com.recipe.recipe_back.entity.MaterialEntity;
import com.recipe.recipe_back.entity.RecipeWriteSequenceEntity;
// import com.recipe.recipe_back.entity.MaterialCategoriesEntity;
// import com.recipe.recipe_back.entity.MaterialEntity;
// import com.recipe.recipe_back.entity.RecipeWriteSequenceEntity;
import com.recipe.recipe_back.repository.BoardRepository;
import com.recipe.recipe_back.repository.CookingFinishImageRepository;
import com.recipe.recipe_back.repository.FavoriteRepository;
import com.recipe.recipe_back.repository.MaterialCategoriesRepository;
import com.recipe.recipe_back.repository.MaterialRepository;
import com.recipe.recipe_back.repository.RecipeWriteSequenceRepository;
// import com.recipe.recipe_back.repository.MaterialCategoriesRepository;
// import com.recipe.recipe_back.repository.MaterialRepository;
// import com.recipe.recipe_back.repository.RecipeWriteSequenceRepository;
import com.recipe.recipe_back.repository.UserRepository;
import com.recipe.recipe_back.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImplement implements BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final FavoriteRepository favoriteRepository;
    private final RecipeWriteSequenceRepository recipeWriteSequenceRepository;
    private final MaterialCategoriesRepository materialCategoriesRepository;
    private final MaterialRepository materialRepository;
    private final CookingFinishImageRepository cookingFinishImageRepository;

    @Override
    public ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, RecipeWriteSequenceItem item,
            String email) {

        try {

            boolean existedUser = userRepository.existsByEmail(email);
            if (!existedUser)
                return PostBoardResponseDto.notExistUser();

            BoardEntity boardEntity = new BoardEntity(dto, email);
            boardRepository.save(boardEntity);

            List<String> materialTitleList = dto.getMaterialTitle();
            Integer boardNumber = boardEntity.getBoardNumber();

            // 재료 카테고리 엔터티 생성 및 저장
            List<MaterialCategoriesEntity> materialCategoriesEntities = new ArrayList<>();
            for (String materialTitle : materialTitleList) {
                MaterialCategoriesEntity materialCategoriesEntity = new MaterialCategoriesEntity(boardNumber,
                        materialTitle);
                materialCategoriesEntities.add(materialCategoriesEntity);
            }
            materialCategoriesRepository.saveAll(materialCategoriesEntities);

            // 완성 사진 엔터티 생성 및 저장
            List<String> imageUrlList = dto.getImageUrlList();
            List<CookingFinishImageEntity> cookingFinishImageEntities = new ArrayList<>();
            for (String imageUrl : imageUrlList) {
                CookingFinishImageEntity cookingFinishImageEntity = new CookingFinishImageEntity(boardNumber,
                        imageUrl);
                cookingFinishImageEntities.add(cookingFinishImageEntity);
            }

            cookingFinishImageRepository.saveAll(cookingFinishImageEntities);

            List<String> recipeWriteSequence = dto.getRecipeWriteSequence();
            List<RecipeWriteSequenceEntity> recipeWriteSequenceEntities = new ArrayList<>();
            for (String recipeWriteSequenceItem : recipeWriteSequence) {
                RecipeWriteSequenceEntity recipeWriteSequenceEntity = new RecipeWriteSequenceEntity(boardNumber,
                        boardNumber, boardNumber, recipeWriteSequenceItem, recipeWriteSequenceItem);
                recipeWriteSequenceEntities.add(recipeWriteSequenceEntity);
            }

            recipeWriteSequenceRepository.saveAll(recipeWriteSequenceEntities);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email) {

        try {

            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null)
                return PutFavoriteResponseDto.notExistBoard();

            boolean existedUser = userRepository.existsByEmail(email);
            if (!existedUser)
                return PutFavoriteResponseDto.notExistUser();

            boolean isFavorite = favoriteRepository.existsByUserEmailAndBoardNumber(email, boardNumber);

            FavoriteEntity favoriteEntity = new FavoriteEntity(email, boardNumber);

            if (isFavorite) {
                favoriteRepository.delete(favoriteEntity);
                boardEntity.decreaseFavoriteCount();
            } else {
                favoriteRepository.save(favoriteEntity);
                boardEntity.increaseFavoriteCount();
            }

            boardRepository.save(boardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PutFavoriteResponseDto.success();
    }

}
