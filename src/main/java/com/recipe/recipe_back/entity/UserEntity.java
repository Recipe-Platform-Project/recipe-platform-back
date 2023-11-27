package com.recipe.recipe_back.entity;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.recipe.recipe_back.dto.request.auth.SignUpRequestDto;
import com.recipe.recipe_back.dto.request.user.PatchNicknameRequestDto;
import com.recipe.recipe_back.dto.request.user.PatchProfileImageRequestDto;
import com.recipe.recipe_back.dto.request.userPage.PatchProfileCommentRequestDto;
import com.recipe.recipe_back.entity.primaryKey.SubscirbePk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
@Table(name = "user")
// @IdClass(SubscirbePk.class)
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


    //유저 비밀번호 변경
    public void patchUserPassword(String newPassword){
        this.password = newPassword;
    }

    //유저 임시 비밀번호 발급
    public void updatePassword(String newPassword) {
        this.password = new BCryptPasswordEncoder().encode(newPassword);
    }

    public void defaultProfileImage(String profileImageUrl){
        if(profileImageUrl == null){
            String[] defaultImageUrls = {
                "https://cdn.pixabay.com/photo/2023/10/02/14/00/egg-8289259_1280.png",
                "https://cdn.pixabay.com/photo/2023/10/04/18/49/pizza-8294340_1280.png",
                "https://cdn.pixabay.com/photo/2022/01/11/19/43/avocado-6931344_1280.jpg",
                "https://cdn.pixabay.com/photo/2021/07/21/17/25/sandwich-6483576_1280.jpg",
                "https://cdn.pixabay.com/photo/2021/04/19/11/34/donut-6191207_1280.jpg"
            };

            int randomIndex = new Random().nextInt(defaultImageUrls.length);

            this.profileImageUrl = defaultImageUrls[randomIndex];
        }
        else{
            this.profileImageUrl = profileImageUrl;
        }

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

    public void increaseFollowCount() {
        this.followCount++;
    }

    public void decreaseFollowCount() {
        this.followCount--;
    }

}
