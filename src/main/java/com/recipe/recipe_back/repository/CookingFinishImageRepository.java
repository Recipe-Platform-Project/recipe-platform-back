package com.recipe.recipe_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.recipe_back.entity.CookingFinishImageEntity;

@Repository
public interface CookingFinishImageRepository extends JpaRepository<CookingFinishImageEntity, Integer> {

    List<CookingFinishImageEntity> findByBoardNumber(Integer boardNumber);
}
