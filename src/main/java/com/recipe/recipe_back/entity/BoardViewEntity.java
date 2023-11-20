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
    private String title;
    private String boardTitleImage;
    private int favoriteCount;
    private int starRanting;
    private String wirteNickname;
    private String writeProfileImage;
}
