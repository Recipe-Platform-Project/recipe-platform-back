package com.recipe.recipe_back.entity;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.recipe.recipe_back.dto.request.board.PatchCommentRequestDto;
import com.recipe.recipe_back.dto.request.board.PostCommentRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "reple_comment")
@Table(name = "reple_comment")
public class CommentEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentNumber;
    private int boardNumber;
    private String userEmail;
    private String contents;
    private String writeDatetime;

    public CommentEntity(PostCommentRequestDto dto, Integer boardNumber, String email){
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String writeDatetime = simpleDateFormat.format(now);

        this.boardNumber = boardNumber;
        this.userEmail = email;
        this.contents = dto.getContents();
        this.writeDatetime = writeDatetime;
    }

    public void patch(PatchCommentRequestDto dto){
        this.contents = dto.getContents();
    }
}
