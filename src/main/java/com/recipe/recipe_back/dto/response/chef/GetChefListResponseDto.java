package com.recipe.recipe_back.dto.response.chef;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.common.object.ChefListItem;
import com.recipe.recipe_back.dto.response.ResponseCode;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.ResponseMessage;
import com.recipe.recipe_back.entity.BoardEntity;
import com.recipe.recipe_back.entity.UserEntity;

import lombok.Getter;

@Getter
public class GetChefListResponseDto extends ResponseDto {
    
    private List<ChefListItem> chefList;

    private GetChefListResponseDto(String code, String message, List<UserEntity> userEntities) {
        super(code, message);
        this.chefList = ChefListItem.getList(userEntities);
    }

    public static ResponseEntity<GetChefListResponseDto> success(List<UserEntity> userEntities, List<BoardEntity> boardEntities) {
        GetChefListResponseDto result = new GetChefListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, userEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

}
