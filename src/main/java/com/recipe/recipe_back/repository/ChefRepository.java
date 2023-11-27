package com.recipe.recipe_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recipe.recipe_back.entity.UserEntity;
import com.recipe.recipe_back.repository.resultSet.ChefListResultSet;

import java.util.List;


@Repository
public interface ChefRepository extends JpaRepository<UserEntity, String>{

    boolean existsByNickname(String email);

    // 쉐프 랭킹(구독순)
    @Query (
        value = 
        "SELECT " +
            "U.email AS email, " +
            "U.profile_image_url AS profileImageUrl, " +
            "U.nickname AS nickname, " +
            "U.follow_count AS followCount, " +
            "T1.board_number AS boardNumber, " +
            "T1.favorite_count AS favoriteCount, " +
            "T1.view_count AS viewCount " +
        "FROM ( " +
            "SELECT " +
            "count(B.board_number) AS board_number, " +
            "count(B.favorite_count) AS favorite_count, " +
            "count(B.view_count) AS view_count, " +
            "B.user_email " +
            "FROM board AS B " +
            "GROUP BY B.user_email " +
        ") AS T1 " +
        "LEFT JOIN user AS U " +
        "ON U.email = T1.user_email " +
        "ORDER BY U.follow_count DESC " +
        "LIMIT 50; ",
        nativeQuery = true
    )
    List<ChefListResultSet> findeByChefRanking();

    @Query (
        value = 
        "SELECT " +
            "U.email AS email, " +
            "U.profile_image_url AS profileImageUrl, " +
            "U.nickname AS nickname, " +
            "U.follow_count AS followCount, " +
            "T1.board_number AS boardNumber, " +
            "T1.favorite_count AS favoriteCount, " +
            "T1.view_count AS viewCount " +
        "FROM ( " +
            "SELECT " +
            "count(B.board_number) AS board_number, " +
            "count(B.favorite_count) AS favorite_count, " +
            "count(B.view_count) AS view_count, " +
            "B.user_email " +
            "FROM board AS B " +
            "GROUP BY B.user_email " +
        ") AS T1 " +
        "LEFT JOIN user AS U " +
        "ON U.email = T1.user_email " +
        "ORDER BY T1.favorite_count DESC " +
        "LIMIT 50; ",
        nativeQuery = true
    )
    List<ChefListResultSet> findeByChefRankingLike();
    

    @Query (
        value = 
        "SELECT " +
            "U.email AS email, " +
            "U.profile_image_url AS profileImageUrl, " +
            "U.nickname AS nickname, " +
            "U.follow_count AS followingCount, " + 
            "B.board_number AS boardNumber, " +
            "B.favorite_count AS favoriteCount, " +
            "B.view_count AS viewCount " +
        "FROM user AS U " +
        "LEFT JOIN board AS B " +
        "ON U.email = B.user_email " +
        "ORDER BY B.write_datetime ASC ",
        nativeQuery = true
    )
    List<ChefListResultSet> findeByChefList();
    
    @Query (
        value = 
        "SELECT " +
            "U.email AS email, " +
            "U.profile_image_url AS profileImageUrl, " +
            "U.nickname AS searchNickname, " +
            "U.follow_count AS followingCount, " + 
            "B.board_number AS boardNumber, " +
            "B.favorite_count AS favoriteCount, " +
            "B.view_count AS viewCount " +
        "FROM user AS U " +
        "LEFT JOIN board AS B " +
        "ON U.email = B.user_email " +
        "WHERE U.nickname LIKE '%?1%' " +
        "ORDER BY U.follow_count DESC ",
        nativeQuery = true
    )
    // List<ChefListResultSet> findeByChefSearchList(@Param("nickname") String searchNickname);
    List<ChefListResultSet> findeByChefSearchList(String searchNickname);
    

}
