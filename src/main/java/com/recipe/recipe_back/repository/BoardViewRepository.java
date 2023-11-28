package com.recipe.recipe_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.recipe_back.entity.BoardViewEntity;

@Repository
public interface BoardViewRepository extends JpaRepository<BoardViewEntity, Integer> {

    BoardViewEntity findByBoardNumber(Integer boardNumber);

    List<BoardViewEntity> findTop3ByOrderByFavoriteCountDesc();

    List<BoardViewEntity> findTop12ByOrderByWriteDatetimeDesc();

    List<BoardViewEntity> findTop12ByKindCategoryOrderByFavoriteCountDesc(String category);
}