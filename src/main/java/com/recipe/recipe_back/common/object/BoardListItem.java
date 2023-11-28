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
    private String boardMainImage;
    private String title;
    private String introduce;
    private int viewCount;
    private int commentCount;
    private int favoriteCount;
    private String writerProfileImage;    
    private String writerNickname;
    private String writeDatetime;
    private String tags;
    
    public BoardListItem(BoardViewEntity boardViewEntity){
        this.boardNumber = boardViewEntity.getBoardNumber();
        this.boardMainImage = boardViewEntity.getBoardMainImage();
        this.title = boardViewEntity.getTitle();
        this.introduce = boardViewEntity.getIntroduce();
        this.viewCount = boardViewEntity.getViewCount();
        this.commentCount = boardViewEntity.getCommentCount();
        this.favoriteCount = boardViewEntity.getFavoriteCount();
        this.writerNickname = boardViewEntity.getWriterNickname();
        this.writerProfileImage = boardViewEntity.getWriterProfileImage();
        this.tags = boardViewEntity.getRecipeTagList();
        this.writeDatetime = boardViewEntity.getWriteDatetime();
    }

    public static List<BoardListItem> getList(List<BoardViewEntity> boardViewEntities) {
        List<BoardListItem> list = new ArrayList<>();
        for (BoardViewEntity boardViewEntity : boardViewEntities) {
            BoardListItem boardListItem = new BoardListItem(boardViewEntity);
            list.add(boardListItem);
        }
        return list;
    }
}
