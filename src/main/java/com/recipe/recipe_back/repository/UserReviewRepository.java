package com.recipe.recipe_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.recipe.recipe_back.entity.ReviewEntity;
import com.recipe.recipe_back.repository.resultSet.UserReviewListResultSet;

@Repository
public interface UserReviewRepository extends JpaRepository<ReviewEntity, Integer> {

    @Query(
        value = 
        "SELECT " +
            "B.board_number AS boardNumber, " +
            "B.title AS title, " +
            "R.rating AS rating, " +
            "B.board_main_image AS boardMainImage, " +
            "R.contents AS contents, " +
            "R.comment_image AS commentImage " +
        "FROM review AS R " +
        "INNER JOIN board AS B " +
            "ON R.user_email = B.user_email " +
        "ORDER BY R.write_datetime DESC ",
        nativeQuery = true
    )
    List<UserReviewListResultSet> findByReviewList();
    
}
