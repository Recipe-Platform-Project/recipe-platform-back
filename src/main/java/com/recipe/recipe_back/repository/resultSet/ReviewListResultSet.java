package com.recipe.recipe_back.repository.resultSet;

public interface ReviewListResultSet {

    String getUserEmail();
    String getProfileImageUrl();
    String getNickname();
    String getContents();
    String getWriteDatetime();
    String getCommentImage();
    int getRating();
    
}
