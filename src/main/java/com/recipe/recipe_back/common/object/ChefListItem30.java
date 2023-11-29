package com.recipe.recipe_back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.recipe.recipe_back.entity.UserEntity;
import com.recipe.recipe_back.repository.resultSet.ChefListResultSet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChefListItem30 {
    private String email;
    private String profileImageUrl;
    private String nickname;
    private int followCount;

    public ChefListItem30(UserEntity userEntity) {
        this.email = userEntity.getEmail();
        this.profileImageUrl = userEntity.getProfileImageUrl();
        this.nickname = userEntity.getNickname();
        this.followCount = userEntity.getFollowCount();
    }

    public static List<ChefListItem30> getList(List<UserEntity> userEntities) {
        List<ChefListItem30> list = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            ChefListItem30 chefListItem = new ChefListItem30(userEntity);
            list.add(chefListItem);
        }
        return list;
    }

    
}
