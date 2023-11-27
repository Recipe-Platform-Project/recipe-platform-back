package com.recipe.recipe_back.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.recipe_back.entity.SubscirbeEntity;
import com.recipe.recipe_back.entity.primaryKey.SubscirbePk;

@Repository
public interface ToUserFromUserRepository extends JpaRepository<SubscirbeEntity, SubscirbePk> {
    
    boolean existsByToUserAndFromUser(String toUser, String fromUser);

    boolean existsByToUser(String toUser);
    boolean existsByFromUser(String fromUser);

    SubscirbeEntity findByToUserAndFromUser(String toUser, String fromUser);

    @Transactional
    void deleteByFromUser(String fromUser);
}
