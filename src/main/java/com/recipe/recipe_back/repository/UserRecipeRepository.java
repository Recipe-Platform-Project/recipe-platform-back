package com.recipe.recipe_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.recipe.recipe_back.entity.BoardEntity;
import com.recipe.recipe_back.repository.resultSet.UserRecipeListResultSet;

@Repository
public interface UserRecipeRepository extends JpaRepository<BoardEntity, Integer> {

    @Query(
        value =
        "SELECT " +
            "B.board_number AS boardNumber, " +
            "B.title AS title, " +
            "U.nickname AS nickname, " +
            "B.board_main_image AS boardMainImage, " +
            "B.write_datetime AS writeDatetime " +
        "FROM board AS B " +
        "INNER JOIN user AS U " +
        "ON B.user_email = U.email " +
        "ORDER BY B.write_datetime DESC ",
        nativeQuery = true
    )
    List<UserRecipeListResultSet> findByRecipe();

    @Query (
        value = 
        "SELECT " +
            "B.board_number AS boardNumber, " +
            "B.title AS title, " +
            "U.nickname AS nickname, " +
            "B.board_main_image AS boardMainImage, " +
            "B.write_datetime AS writeDatetime " +
        "FROM board AS B " +
        "INNER JOIN user AS U " +
        "ON B.user_email = U.email " +
        "WHERE true " +
        "AND B.title LIKE '%?1%' " +
        "ORDER BY B.write_datetime DESC ",
        nativeQuery = true
    )
    List<UserRecipeListResultSet> findByUserRecipeSearchList(String searchWord);
    
}
