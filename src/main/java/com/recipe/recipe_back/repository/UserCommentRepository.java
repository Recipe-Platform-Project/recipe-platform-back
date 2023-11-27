package com.recipe.recipe_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.recipe.recipe_back.entity.RepleCommentEntity;
import com.recipe.recipe_back.repository.resultSet.UserRepleCommentListResultSet;

@Repository
public interface UserCommentRepository extends JpaRepository<RepleCommentEntity, Integer>{

    @Query(
        value = 
        "SELECT " +
            "T1.board_number AS boardNumber, " +
            "T1.board_main_image AS boardMainImage, " +
            "T1.title AS Title, " +
            "T1.nickname AS boardNickname, " +
            "T2.comment_number AS commentNumber, " +
            "T2.nickname AS repleCommentNickname, " +
            "T2.contents AS contents, " +
            "T2.write_datetime AS writeDatetime " +
        "FROM ( " +
            "SELECT " +
            "B.board_number, B.board_main_image, B.title, U.nickname " +
            "FROM user AS U " +
            "INNER JOIN board AS B " +
            "ON B.user_email = U.email " +
        ") AS T1 INNER JOIN " +
        "( " +
            "SELECT " +
            "U.nickname, C.contents, C.write_datetime, C.comment_number " +
            "FROM reple_comment AS C " +
            "LEFT JOIN user AS U " +
            "ON C.user_email = U.email " +
        ") AS T2 " +
        "ON T1.board_number = T2.comment_number " +
        "ORDER BY T2.write_datetime DESC; ",
            nativeQuery = true 
        )
    List<UserRepleCommentListResultSet> findByRepleCommentList();
}