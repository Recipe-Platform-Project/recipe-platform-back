package com.recipe.recipe_back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardNumber;
    private String boardMainImage;
    private String title;
    private String introduce;
    private String WriteDatetime;
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

    public void increaseCommentCount() {
        this.commentCount++;
    }

    public void decreaseCommentCount() {
        this.commentCount--;
    }
}
