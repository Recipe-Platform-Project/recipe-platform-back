package com.recipe.recipe_back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="board")
@Table(name="board")
public class BoardEntity {
    
    @Id
    private int boardNumber;
    private String boardMainImageUrl;
    private String title;
    private String introduce;
    private String boardContent;
    private String writeDatetime;
    private int viewCount;
    private String userEmail;
    private int commentCount;
    private int favoriteCount;
    private String kindCategory;
    private String wayCategory;
    private String materialCategory;
    private String videoLink;
    private String cookingTip;
    private String requiredTime;
    private String difficulty;
    private String peopleCount;

    public void increaseBoardNumber() {
        this.boardNumber++;
    }

    public void decreaseBoardNumber() {
        this.boardNumber--;
    }

}
