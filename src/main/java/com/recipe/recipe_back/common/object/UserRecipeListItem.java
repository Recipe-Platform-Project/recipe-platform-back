package com.recipe.recipe_back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.recipe.recipe_back.entity.BoardEntity;
import com.recipe.recipe_back.entity.UserEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRecipeListItem {
    private int boardNumber;
    private String title;
    private String nickname;
    private String boardMainImage;
    private String writeDatetime;
    
    private UserRecipeListItem(BoardEntity boardEntity, UserEntity userEntity) {
        this.boardNumber = boardEntity.getBoardNumber();
        this.title = boardEntity.getTitle();
        this.nickname = userEntity.getNickname();
        this.boardMainImage = boardEntity.getBoardMainImageUrl();
        this.writeDatetime = boardEntity.getWriteDatetime();
    }

    public static List<UserRecipeListItem> getList(List<BoardEntity> boardEntities, List<UserEntity> userEntities) {
        List<UserRecipeListItem> list = new ArrayList<>();
        for (BoardEntity boardEntity: boardEntities) {
            for (UserEntity userEntity: userEntities) {
                UserRecipeListItem userRecipeListItem = new UserRecipeListItem(boardEntity, userEntity);
                list.add(userRecipeListItem);
            }
        }
        return list;
    }
}
