package com.recipe.recipe_back.dto.response.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.recipe.recipe_back.dto.response.ResponseCode;
import com.recipe.recipe_back.dto.response.ResponseDto;
import com.recipe.recipe_back.dto.response.ResponseMessage;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MembershipWithdrawalResposneDto extends ResponseDto{
    
    private MembershipWithdrawalResposneDto(String code, String message){
        super(code, message);
    }

    public static ResponseEntity<MembershipWithdrawalResposneDto> success(){
        MembershipWithdrawalResposneDto result = new MembershipWithdrawalResposneDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> membershipWithdrawalFailed(){
        ResponseDto result = new ResponseDto(ResponseCode.WITHDRAWAL_FAILED, ResponseMessage.WITHDRAWAL_FAILED);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
