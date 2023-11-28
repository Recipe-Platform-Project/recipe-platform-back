package com.recipe.recipe_back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.recipe.recipe_back.dto.request.board.PatchReviewRequestDto;
import com.recipe.recipe_back.dto.request.board.PostReviewRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "review")
@Table(name = "review")
public class ReviewEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentNumber;
    private int boardNumber;
    private String userEmail;
    private String contents;
    private String writeDatetime;
    private int rating;
    private String commentImage;

    public ReviewEntity(PostReviewRequestDto dto, Integer boardNumber, String email){
        java.util.Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String writeDatetime = simpleDateFormat.format(now);

        this.boardNumber = boardNumber;
        this.userEmail = email;
        this.contents = dto.getContents();
        this.writeDatetime = writeDatetime;
        this.rating = dto.getRating();
        this.commentImage = dto.getCommentImage();
    }

    public void patch(PatchReviewRequestDto dto){
        this.contents = dto.getContents();
        this.rating = dto.getRating();
        this.commentImage = dto.getCommentImage();
    }
}
