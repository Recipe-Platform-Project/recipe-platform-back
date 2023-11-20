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
@Entity(name="review")
@Table(name="review")
public class ReviewEntity {

    @Id
    private int commentNumber;
    private String userEmail;
    private int boardNumber;
    private String contents;
    private String writeDateTime;
    private int parentCommentNumber;
    private String rating;
    private String commentImage;

}
