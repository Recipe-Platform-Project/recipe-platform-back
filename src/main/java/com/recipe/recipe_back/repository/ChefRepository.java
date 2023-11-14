package com.recipe.recipe_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.recipe.recipe_back.entity.UserEntity;

import java.util.List;


@Repository
public interface ChefRepository extends JpaRepository<UserEntity, String>{

    @Query (
        value = 
        "SELECT " +
            "U.email AS email, " +
            "U.profile_image_url AS profileImageUrl, " +
            "U.nickname AS nickname, " +
            "U.follow_count AS followCount, " + 
            "B.board_number AS boardNumber, " +
            "B.faborit_count AS faboritCount, " +
            "B.view_count AS viewCount " +
        "FROM user AS U " +
        "INNER JOIN board AS B " +
        "ON U.email = B.user_email " +
        "ORDER BY U.follow_count DESC " +
        "LIMIT 50 ",
        nativeQuery = true
    )
    List<UserEntity> findeByChefRanking(String email);

    @Query (
        value = 
        "SELECT " +
            "U.email AS email, " +
            "U.profile_image_url AS profileImageUrl, " +
            "U.nickname AS nickname, " +
            "U.follow_count AS followCount, " + 
            "B.board_number AS boardNumber, " +
            "B.faborit_count AS faboritCount, " +
            "B.view_count AS viewCount " +
        "FROM user AS U " +
        "INNER JOIN board AS B " +
        "ON U.email = B.user_email ",
        nativeQuery = true
    )
    List<UserEntity> findeByChefList(String email);

}
