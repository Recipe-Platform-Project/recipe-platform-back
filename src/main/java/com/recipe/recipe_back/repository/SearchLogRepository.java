package com.recipe.recipe_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recipe.recipe_back.entity.SearchLogEntity;
import com.recipe.recipe_back.repository.resultSet.SearchWordResultSet;

public interface SearchLogRepository extends JpaRepository<SearchLogEntity, Integer>{
    @Query(
        value = 
        "SELECT search_word AS search, COUNT(*) AS count "+
        "FROM search_log "+
        "GROUP BY search_word "+
        "ORDER BY count DESC "+
        "LIMIT 12",
        nativeQuery=true
    )
    List<SearchWordResultSet> getPopulerWordList();
}
