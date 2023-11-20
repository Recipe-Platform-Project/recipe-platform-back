package com.recipe.recipe_back.common.object;

import java.util.ArrayList;
import java.util.List;

import com.recipe.recipe_back.entity.BoardEntity;
import com.recipe.recipe_back.entity.ReviewEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRecipeReviewListItem {
    private int boardNumber;
    private String title;
    private String rating;
    private String boardMainImage;
    private String writeDatetime;
    private String contents;
    private String commentImage;

    public UserRecipeReviewListItem(BoardEntity boardEntity, ReviewEntity reviewEntity) {
        this.boardNumber = boardEntity.getBoardNumber();
        this.title = boardEntity.getTitle();
        this.rating = reviewEntity.getRating();
        this.boardMainImage = boardEntity.getBoardMainImageUrl();
        this.contents = reviewEntity.getContents();
        this.commentImage = reviewEntity.getCommentImage();
    }

    public static List<UserRecipeReviewListItem> getList(List<BoardEntity> boardEntities, List<ReviewEntity> reviewEntities) {
        List<UserRecipeReviewListItem> list = new ArrayList<>();
        for (BoardEntity boardEntity: boardEntities) {
            for (ReviewEntity reviewEntity: reviewEntities) {
                UserRecipeReviewListItem userRecipeReviewListItem = new UserRecipeReviewListItem(boardEntity, reviewEntity);
                list.add(userRecipeReviewListItem);
            }
        }
        return list;
    }
}
