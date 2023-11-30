package com.recipe.recipe_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recipe.recipe_back.entity.UserEntity;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recipe.recipe_back.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);

    boolean existsByTelNumber(String telNumber);
    boolean existsByPassword(String Password);

    UserEntity findByTelNumber(String telNumber);

    UserEntity findByEmail(String email);

    // Email, Password Found
    UserEntity findByNameAndTelNumber(String name, String telNumber);
    UserEntity findByNameAndEmail(String name, String email);

    @Query(value = "SELECT * " +
            "FROM user " +
            "WHERE email IN ( " +
            "SELECT user_email " +
            "FROM favorite " +
            "WHERE board_number = ?1 " +
            ") ", nativeQuery = true)
    List<UserEntity> findByBoardFavorite(Integer boardNumber);

    //membership withdrawal
    @Transactional
    @Modifying
    @Query("DELETE FROM user u WHERE u.email = :email")
    void deleteByEmail(@Param("email") String email);

}
