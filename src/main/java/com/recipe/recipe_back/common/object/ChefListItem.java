package com.recipe.recipe_back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.recipe.recipe_back.entity.UserEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChefListItem {
    private String email;
    private String profileImageUrl;
    private String nickname;
    private int followCount;

    public ChefListItem(UserEntity userEntity) {
        this.email = userEntity.getEmail();
        this.profileImageUrl = userEntity.getProfileImageUrl();
        this.nickname = userEntity.getNickname();
        this.followCount = userEntity.getFollowCount();
    }

    public static List<ChefListItem> getList(List<UserEntity> userEntities) {
        List<ChefListItem> list = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            ChefListItem chefListItem = new ChefListItem(userEntity);
            list.add(chefListItem);
        }
        return list;
    }

    
}
