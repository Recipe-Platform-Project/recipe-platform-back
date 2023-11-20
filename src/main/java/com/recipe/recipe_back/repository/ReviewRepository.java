package com.recipe.recipe_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.recipe_back.entity.ReviewEntity;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {

    boolean existsByCommentNumber(Integer commentNumber);

    List<ReviewEntity> findByOrderByWriteDateTimeDesc();
    
}
