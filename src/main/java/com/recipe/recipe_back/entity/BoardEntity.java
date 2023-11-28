package com.recipe.recipe_back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// import com.recipe.recipe_back.common.object.MaterialCategoriesListItem;
// import com.recipe.recipe_back.common.object.RecipeWriteSequenceListItem;
// import com.recipe.recipe_back.dto.request.board.PatchBoardRequestDto;
import com.recipe.recipe_back.dto.request.board.PostBoardRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "board")
@Table(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardNumber;
    private String userEmail;
    private String boardMainImage;
    private String title;
    private String introduce;
    private String writeDatetime;
    private int viewCount;
    private int commentCount;
    private String kindCategory;
    private String wayCategory;
    private String materialCategory;
    private String videoLink;
    private String cookingTip;
    private String requiredTime;
    private String difficulty;
    private String peopleCount;
    private int favoriteCount;

    public BoardEntity(PostBoardRequestDto dto, String email) {
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String writeDatetime = simpleDateFormat.format(now);

        this.userEmail = email;
        this.boardMainImage = dto.getBoardMainImage();
        this.title = dto.getTitle();
        this.introduce = dto.getIntroduce();
        this.writeDatetime = writeDatetime;
        this.kindCategory = dto.getKindCategory();
        this.wayCategory = dto.getWayCategory();
        this.materialCategory = dto.getMaterialCategory();
        this.videoLink = dto.getVideoLink();
        this.cookingTip = dto.getCookingTip();
        this.requiredTime = dto.getRequiredTime();
        this.difficulty = dto.getDifficulty();
        this.peopleCount = dto.getPeopleCount();
        this.commentCount = 0;
        this.viewCount = 0;

    }

    // public void patch(PatchBoardRequestDto dto, String email, BoardEntity
    // boardEntity) {
    // this.boardNumber = boardEntity.getBoardNumber();
    // this.boardMainImage = dto.getBoardMainImage();
    // this.title = dto.getTitle();
    // this.introduce = dto.getIntroduce();
    // this.sequenceIndex = dto.getSequenceIndex();
    // this.kindCategory = dto.getKindCategory();
    // this.wayCategory = dto.getWayCategory();
    // this.materialCategory = dto.getMaterialCategory();
    // this.videoLink = dto.getVideoLink();
    // this.cookingTip = dto.getCookingTip();
    // this.requiredTime = dto.getRequiredTime();
    // this.difficulty = dto.getDifficulty();
    // this.peopleCount = dto.getPeopleCount();
    // this.recipeTag = dto.getRecipeTag();
    // this.materialCategoriesSequence = dto.getMaterialCategoriesSequence();
    // }

    // public void increaseViewCount() {
    // this.viewCount++;
    // }

    // public void increaseCommentCount() {
    // this.commentCount++;
    // }

    public void increaseFavoriteCount() {
        this.favoriteCount++;
    }

    public void decreaseFavoriteCount() {
        this.favoriteCount--;
    }

}
