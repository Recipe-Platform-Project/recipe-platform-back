package com.recipe.recipe_back.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.recipe.recipe_back.entity.CommentEntity;
import com.recipe.recipe_back.repository.resultSet.CommentListResultSet;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

    @Query(value = "SELECT " +
            "U.nickname AS nickname, " +
            "U.profile_image_url AS profileImage, " +
            "C.contents AS contents, " +
            "C.write_datetime AS writeDatetime " +
            "FROM reple_comment AS C " +
            "INNER JOIN user AS U " +
            "ON C.user_email = U.email " +
            "WHERE C.board_number = ?1 " +
            "ORDER BY C.write_datetime ", nativeQuery = true)
    List<CommentListResultSet> findByCommentList(Integer boardNumber);

    CommentEntity findByCommentNumber(Integer commentNumber);

    // @Transactional
    // void deleteByCommentNumber(Integer commentNumber);
}
