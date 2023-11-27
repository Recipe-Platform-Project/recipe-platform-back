package com.recipe.recipe_back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.recipe.recipe_back.repository.resultSet.UserReviewListResultSet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReviewListItem {
    private int boardNumber;
    private String title;
    private String rating;
    private String boardMainImage;
    private String writeDatetime;
    private String contents;
    private String commentImage;

    public UserReviewListItem(UserReviewListResultSet resultSet) {
        this.boardNumber = resultSet.getBoardNumber();
        this.title = resultSet.getTitle();
        this.rating = resultSet.getRating();
        this.boardMainImage = resultSet.getBoardMainImage();
        this.contents = resultSet.getContents();
        this.commentImage = resultSet.getCommentImage();
    }

    public static List<UserReviewListItem> getList(List<UserReviewListResultSet> resultSets) {
        List<UserReviewListItem> list = new ArrayList<>();
        for (UserReviewListResultSet resultSet: resultSets) {
            UserReviewListItem userReviewListItem = new UserReviewListItem(resultSet);
            list.add(userReviewListItem);
        }
        return list;
    }
}
