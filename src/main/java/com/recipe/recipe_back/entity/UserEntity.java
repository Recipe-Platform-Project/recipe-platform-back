package com.recipe.recipe_back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.recipe.recipe_back.dto.request.auth.SignUpRequestDto;
import com.recipe.recipe_back.dto.request.user.PatchNicknameRequestDto;
import com.recipe.recipe_back.dto.request.user.PatchProfileImageRequestDto;
import com.recipe.recipe_back.dto.request.userPage.PatchProfileCommentRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
@Table(name = "user")
public class UserEntity {
    @Id
    private String email;
    private String password;
    private String nickname;
    private String name;
    private String telNumber;
    private Boolean agreedPersonalEssential;
    private Boolean agreedPersonCollection;
    private Boolean agreedPersonProsessing;
    private String profileImageUrl;
    private String profileComment;
    private int followingCount;
    private int followCount;

    public UserEntity(SignUpRequestDto dto){
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.nickname = dto.getNickname();
        this.name = dto.getName();
        this.telNumber = dto.getTelNumber();
        this.agreedPersonalEssential = dto.getAgreedPersonalEssential();
        this.agreedPersonCollection = dto.getAgreedPersonCollection();
        this.agreedPersonProsessing = dto.getAgreedPersonProsessing();
        this.profileImageUrl = dto.getProfileImageUrl();
    }

    public void patchNickname(PatchNicknameRequestDto dto) {
        this.nickname = dto.getNickname();
    }

    public void patchProfileImage(PatchProfileImageRequestDto dto) {
        this.profileImageUrl = dto.getProfileImage();
    }

    public void patchProfileComment(PatchProfileCommentRequestDto dto){
        this.profileComment = dto.getProfileComment();
    }

    public void increaseFollowingCount() {
        this.followingCount++;
    }

    public void decreaseFollowingCount() {
        this.followingCount--;
    }

    public void iscreaseFollowCount() {
        this.followCount++;
    }

    public void decreaseFollowCount() {
        this.followCount--;
    }
}
