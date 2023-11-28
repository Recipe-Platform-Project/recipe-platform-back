package com.recipe.recipe_back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.recipe.recipe_back.repository.resultSet.ChefListResultSet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChefListItem {
    private String profileImageUrl;
    private String nickname;
    private Integer followCount;
    private Integer boardNumber;
    private Integer favoriteCount;
    private Integer viewCount;

    public ChefListItem(ChefListResultSet resultSet) {
        this.profileImageUrl = resultSet.getProfileImageUrl();
        this.nickname = resultSet.getNickname();
        this.followCount = resultSet.getFollowCount();
        this.boardNumber = resultSet.getBoardNumber();
        this.favoriteCount = resultSet.getFavoriteCount();
        this.viewCount = resultSet.getViewCount();
    }

    public static List<ChefListItem> getList(List<ChefListResultSet> resultSets) {
        List<ChefListItem> list = new ArrayList<>();

        for (ChefListResultSet resultSet: resultSets) {
            ChefListItem chefListItem = new ChefListItem(resultSet);
            list.add(chefListItem);
        }
        return list;
    }

    
}
