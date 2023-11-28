package com.recipe.recipe_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recipe.recipe_back.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);

    boolean existsByTelNumber(String telNumber);

    UserEntity findByTelNumber(String telNumber);

    UserEntity findByEmail(String email);

    // Email, Password Found
    UserEntity findByNameAndTelNumber(String name, String telNumber);

    @Query(value = "SELECT * " +
            "FROM user " +
            "WHERE email IN ( " +
            "SELECT user_email " +
            "FROM favorite " +
            "WHERE board_number = ?1 " +
            ") ", nativeQuery = true)
    List<UserEntity> findByBoardFavorite(Integer boardNumber);

}
