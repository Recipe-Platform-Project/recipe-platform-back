package com.recipe.recipe_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.recipe.recipe_back.entity.ReviewEntity;
import com.recipe.recipe_back.repository.resultSet.ReviewListResultSet;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer>{
    
    @Query(value = "SELECT " +
            "U.nickname AS nickname, " +
            "U.profile_image_url AS profileImage, " +
            "R.contents AS contents, " +
            "R.write_datetime AS writeDatetime, " +
            "R.comment_image AS commentImage, " +
            "R.rating AS rating, " +
            "R.user_email AS userEmail " +
            "FROM review AS R " +
            "INNER JOIN user AS U " +
            "ON R.user_email = U.email " +
            "WHERE R.board_number = ?1 " +
            "ORDER BY R.write_datetime ", nativeQuery = true)
    List<ReviewListResultSet> findByReviewList(Integer boardNumber);

    ReviewEntity findByCommentNumber(Integer commentNumber);
}
