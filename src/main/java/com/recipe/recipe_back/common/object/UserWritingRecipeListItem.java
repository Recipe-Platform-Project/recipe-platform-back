package com.recipe.recipe_back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.recipe.recipe_back.repository.resultSet.UserReviewListResultSet;
import com.recipe.recipe_back.repository.resultSet.UserWritingRecipeListResultSet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserWritingRecipeListItem {
    private int boardNumber;
    private String title;
    private String boardContent;
    private String boardMainImage;
    private String writeDatetime;

    public UserWritingRecipeListItem(UserWritingRecipeListResultSet resultSet) {
        this.boardNumber = resultSet.getoBardNumber();
        this.title = resultSet.getTitle();
        this.boardContent = resultSet.getWriteContent();
        this.boardMainImage = resultSet.getBoardMainImage();
        this.writeDatetime = resultSet.getWriteDatetime();
    }

    public static List<UserWritingRecipeListItem> getList(List<UserWritingRecipeListResultSet> resultSets) {
        List<UserWritingRecipeListItem> list = new ArrayList<>();
        for (UserWritingRecipeListResultSet resultSet: resultSets) {
            UserWritingRecipeListItem userReviewListItem = new UserWritingRecipeListItem(resultSet);
            list.add(userReviewListItem);
        }
        return list;
    }
    
}
