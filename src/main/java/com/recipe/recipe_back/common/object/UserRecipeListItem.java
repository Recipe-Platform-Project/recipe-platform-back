package com.recipe.recipe_back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.recipe.recipe_back.repository.resultSet.UserRecipeListResultSet;

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
    
    private UserRecipeListItem(UserRecipeListResultSet resultSet) {
        this.boardNumber = resultSet.getBoardNumber();
        this.title = resultSet.getTitle();
        this.nickname = resultSet.getNickname();
        this.boardMainImage = resultSet.getBoardMainImage();
        this.writeDatetime = resultSet.getWriteDatetime();
    }

    public static List<UserRecipeListItem> getList(List<UserRecipeListResultSet> resultSets) {
        List<UserRecipeListItem> list = new ArrayList<>();
        for (UserRecipeListResultSet resultSet: resultSets) {
            UserRecipeListItem userRecipeListItem = new UserRecipeListItem(resultSet);
            list.add(userRecipeListItem);
        }
        return list;
    }
}
