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
@Entity(name="user")
@Table(name="user")
public class UserEntity {

    @Id
    private String email;
    private String password;
    private String nickname;
    private String name;
    private String telNumber;
    private Integer agreedPersonalEssential;
    private Integer agreedPersonCollection;
    private Integer agreedPersonProsessing;
    private String profileImageUrl;
    private String profileComment;
    private int followingCount;
    private int followCount;
    
}
