package com.recipe.recipe_back.dto.response.chef;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.common.object.ChefListItem;
import com.recipe.recipe_back.dto.response.ResponseCode;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.ResponseMessage;
import com.recipe.recipe_back.entity.UserEntity;

import lombok.Getter;

@Getter
public class GetTop30ChefListResponseDto extends ResponseDto{

    private List<ChefListItem> chefList;

    private GetTop30ChefListResponseDto(String code, String message, List<UserEntity> userEntities){
        super(code, message);
        this.chefList = ChefListItem.getList(userEntities);
    }

    public static ResponseEntity<GetTop30ChefListResponseDto> success(List<UserEntity> userEntities) {
        GetTop30ChefListResponseDto result = new GetTop30ChefListResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS, userEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}