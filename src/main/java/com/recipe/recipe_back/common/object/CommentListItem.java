package com.recipe.recipe_back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.recipe.recipe_back.repository.resultSet.CommentListResultSet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentListItem {
    private String nickname;
    private String contents;
    private String writeDatetime;
    private String profileImageUrl;

    public CommentListItem(CommentListResultSet commentListResultSet){
        this.nickname = commentListResultSet.getNickname();
        this.contents = commentListResultSet.getContents();
        this.writeDatetime = commentListResultSet.getWriteDatetime();
        this.profileImageUrl = commentListResultSet.getProfileImageUrl();
    }

    public static List<CommentListItem> getList(List<CommentListResultSet> resultSets){
        List<CommentListItem> list = new ArrayList<>();
        for (CommentListResultSet resultSet: resultSets){
            CommentListItem commentListItem = new CommentListItem(resultSet);
            list.add(commentListItem);
        }
        return list;
    }
}
