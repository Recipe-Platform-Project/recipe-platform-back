package com.recipe.recipe_back.dto.response;

public interface ResponseMessage {

    String SUCCESS = "Success.";

    String VALIDATION_FAILED = "Validation failed.";
    String DUPLICATED_EMAIL = "Duplicate email.";
    String DUPLICATED_NICKNAME = "Duplicate nickname.";
    String DUPLICATED_TEL_NUMBER = "Duplicate telephone number.";

    String DUPLICATED_PASSWORD = "Duplicate Password";
    String DUPLICATED_PROFILE_COMMENT = "Duplicate profile comment.";
    String NOT_EXIST_USER = "This user does not exist.";
    String NOT_EXIST_BOARD = "This board does not exist.";
    String NOT_EXIST_COMMENT = "This comment does not exist";

    String SAME_PASSWORD = "Same Password";
    String PASSWORD_MISSMATCH = "Password Missmatch";

    String WITHDRAWAL_FAILED = "Membership Withdrawal Failed";

    String FIND_USER_FAILED = "Find User ID Failed";
    String SIGN_IN_FAILED = "Login information mismatch.";

    String NO_PERMISSION = "Do not have permission.";

    String DATABASE_ERROR = "Database error.";

    String AUTHORIZATION_FAILED = "Authorization failed.";

}
