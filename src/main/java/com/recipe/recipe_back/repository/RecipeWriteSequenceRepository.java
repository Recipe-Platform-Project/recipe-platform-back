package com.recipe.recipe_back.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.recipe_back.entity.RecipeWriteSequenceEntity;

@Repository
public interface RecipeWriteSequenceRepository extends JpaRepository<RecipeWriteSequenceEntity, Integer>{
    
}
