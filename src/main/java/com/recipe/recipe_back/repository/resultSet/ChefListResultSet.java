package com.recipe.recipe_back.repository.resultSet;

public interface ChefListResultSet {
    String getProfileImageUrl();
    String getNickname();
    String getTitle();
    int getFollowCount();
    Integer getBoardNumber();
    Integer getFavoriteCount();
    Integer getViewCount();
}
