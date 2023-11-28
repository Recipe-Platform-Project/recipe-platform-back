package com.recipe.recipe_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.recipe_back.entity.MaterialEntity;

@Repository
public interface MaterialRepository extends JpaRepository<MaterialEntity, Integer> {

    List<MaterialEntity> findByMainMaterialFK(Integer materialCategoriesSequence);

}
