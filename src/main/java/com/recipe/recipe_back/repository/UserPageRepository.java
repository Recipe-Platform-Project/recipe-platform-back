package com.recipe.recipe_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.recipe.recipe_back.entity.BoardEntity;
import com.recipe.recipe_back.entity.UserEntity;

@Repository
public interface UserPageRepository extends JpaRepository<UserEntity, String>{
    
    boolean existsByProfileComment(String profileComment);
    boolean existsByNickname(String nickname);

    UserEntity findByEmail(String email);

    // @Query(
    //     value = 
    //     "SELECT Count(*) as cnt " +
    //     "FROM board_number ",
    //     nativeQuery = true
    // )
    // List<BoardEntity> findByBoardNumber(Integer boardNumber);
}
