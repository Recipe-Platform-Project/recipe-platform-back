package com.recipe.recipe_back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.recipe.recipe_back.repository.resultSet.ReviewListResultSet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewListItem {
    private String nickname;
    private String contents;
    private String writeDatetime;
    private String profileImageUrl;
    private int rating;
    private String commentImage;
    private String userEmail;

    public ReviewListItem(ReviewListResultSet reviewListResultSet){

        this.nickname = reviewListResultSet.getNickname();
        this.contents = reviewListResultSet.getContents();
        this.writeDatetime = reviewListResultSet.getWriteDatetime();
        this.profileImageUrl = reviewListResultSet.getProfileImageUrl();
        this.rating = reviewListResultSet.getRating();
        this.commentImage = reviewListResultSet.getCommentImage();
        this.userEmail = reviewListResultSet.getUserEmail();
    }

    public static List<ReviewListItem> getList(List<ReviewListResultSet> resultSets){
        List<ReviewListItem> list = new ArrayList<>();
        for (ReviewListResultSet resultSet: resultSets){
            ReviewListItem commentListItem = new ReviewListItem(resultSet);
            list.add(commentListItem);
        }
        return list;
    }
}
