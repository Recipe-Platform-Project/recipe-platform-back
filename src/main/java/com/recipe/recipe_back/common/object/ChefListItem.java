package com.recipe.recipe_back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.recipe.recipe_back.entity.BoardEntity;
import com.recipe.recipe_back.entity.UserEntity;

public class ChefListItem {
    private String email;
    private String profileImageUrl;
    private String nickname;
    private int followCount;
    private int boardNumber;
    private int favoritCount;
    private int viewCount;

    public ChefListItem(UserEntity userEntity, BoardEntity boardEntity) {
        this.email = userEntity.getEmail();
        this.profileImageUrl = userEntity.getProfileImageUrl();
        this.nickname = userEntity.getNickname();
        this.followCount = userEntity.getFollowCount();
        this.boardNumber = boardEntity.getBoardNumber();
        this.favoritCount = boardEntity.getFavoriteCount();
        this.viewCount = boardEntity.getViewCount();
    }

    public static List<ChefListItem> getList(List<UserEntity> userEntities, List<BoardEntity> boardEntities) {
        List<ChefListItem> list = new ArrayList<>();

        for (UserEntity userEntity: userEntities) {
            for(BoardEntity boardEntity: boardEntities){
                ChefListItem chefListItem = new ChefListItem(userEntity, boardEntity);
                list.add(chefListItem);
            }
        }
        return list;
    }
}
