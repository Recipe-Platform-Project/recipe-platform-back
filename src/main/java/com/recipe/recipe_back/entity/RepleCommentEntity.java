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
@Entity(name="reple_comment")
@Table(name="reple_comment")
public class RepleCommentEntity {

    @Id
    private int commentNumber;
    private String userEmail;
    private int boardNumber;
    private String contents;
    private String writeDatetime;
    private int parentCommentNumber;
    
}
