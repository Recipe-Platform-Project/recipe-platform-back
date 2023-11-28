package com.recipe.recipe_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.recipe_back.entity.RecipeWriteSequenceEntity;

@Repository
public interface RecipeWriteSequenceRepository extends JpaRepository<RecipeWriteSequenceEntity, Integer> {

    List<RecipeWriteSequenceEntity> findByBoardNumber(Integer boardNumber);

}
