package com.recipe.recipe_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.recipe_back.entity.MaterialCategoriesEntity;

@Repository
public interface MaterialCategoriesRepository extends JpaRepository<MaterialCategoriesEntity, Integer> {

    List<MaterialCategoriesEntity> findByBoardNumber(Integer boardNumber);

}
