package com.recipe.recipe_back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.recipe.recipe_back.entity.BoardViewEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardListItem {
    private int boardNumber;
    private String title;
    private String boardTitleImage;
    private int favoriteCount;
    private int starRanting;
    private String wirteNickname;
    private String writeProfileImage;

    public BoardListItem(BoardViewEntity boardViewEntity) {
        this.boardNumber = boardViewEntity.getBoardNumber();
        this.title = boardViewEntity.getTitle();
        this.boardTitleImage = boardViewEntity.getBoardTitleImage();
        this.favoriteCount = boardViewEntity.getFavoriteCount();
        this.starRanting = boardViewEntity.getStarRanting();
        this.wirteNickname = boardViewEntity.getWirteNickname();
        this.writeProfileImage = boardViewEntity.getWriteProfileImage();
    }

    public static List<BoardListItem> getList(List<BoardViewEntity> boardViewEntities){
        List<BoardListItem> list = new ArrayList<>();
        for(BoardViewEntity boardViewEntity: boardViewEntities){
            BoardListItem boardListItem = new BoardListItem(boardViewEntity);
            list.add(boardListItem);
        }
        return list;
    }
}
