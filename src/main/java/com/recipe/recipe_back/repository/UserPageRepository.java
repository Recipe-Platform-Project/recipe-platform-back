package com.recipe.recipe_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.recipe_back.entity.BoardEntity;

@Repository
public interface UserPageRepository extends JpaRepository<BoardEntity, Integer> {

    List<BoardEntity> findByOrderByWriteDatetimeDesc();
    
}
