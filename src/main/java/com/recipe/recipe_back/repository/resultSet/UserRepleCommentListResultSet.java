package com.recipe.recipe_back.repository.resultSet;

public interface UserRepleCommentListResultSet {
    Integer getBoardNumber();
    String getTitle();
    String getBoardMainImage();
    String getNickname();
    // String getCommentNickname();
    String getContents();
    String getWriteDatetime();
}
