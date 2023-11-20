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
@Entity(name = "board_view")
@Table(name = "board_view")
public class BoardViewEntity {
    @Id
    private int boardNumber;
    private String boardMainImage;
    private String title;
    private String boardIntroduce;
    private int viewCount;
    private int commentCount;
    private int favoriteCount;
    private String writerProfileImage;    
    private String writerNickname;
    private String recipeTagList;
}
