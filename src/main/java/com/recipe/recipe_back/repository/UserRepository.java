package com.recipe.recipe_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.recipe_back.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, String> {
    
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
    boolean existsByTelNumber(String telNumber);

    UserEntity findByTelNumber(String telNumber);
    UserEntity findByEmail(String email);
    
    //Email, Password Found
    UserEntity findByNameAndTelNumber(String name, String telNumber);
    UserEntity findByNameAndEmail(String name, String email);


}
