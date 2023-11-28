package com.recipe.recipe_back.common.object;

import java.util.List;
import java.util.ArrayList;

import com.recipe.recipe_back.repository.resultSet.UserRepleCommentListResultSet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRepleCommentListItem {
    private int boardNumber;
    private String title;
    private String nickname;
    private String boardMainImage;
    // private String commentNickname;
    private Integer commentNumber;
    private String contents;
    private String writeDatetime;

    public UserRepleCommentListItem(UserRepleCommentListResultSet resultSet) {
        this.boardNumber = resultSet.getBoardNumber();
        this.title = resultSet.getTitle();
        this.nickname = resultSet.getNickname();
        // this.commentNickname = resultSet.getCommentNickname();
        this.boardMainImage = resultSet.getBoardMainImage();
        this.contents = resultSet.getContents();
        this.writeDatetime = resultSet.getWriteDatetime();
    }

    public static List<UserRepleCommentListItem> getList(List<UserRepleCommentListResultSet> resultSets) {
        List<UserRepleCommentListItem> list = new ArrayList<>();
        for (UserRepleCommentListResultSet resultSet: resultSets) {
            UserRepleCommentListItem userRepleCommentListItem = new UserRepleCommentListItem(resultSet);
            list.add(userRepleCommentListItem);
        }
        return list;
    }
}
