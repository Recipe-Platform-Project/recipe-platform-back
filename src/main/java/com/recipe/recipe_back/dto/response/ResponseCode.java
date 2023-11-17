package com.recipe.recipe_back.dto.response;

public interface ResponseCode {

    String SUCCESS = "SU";
    String VALIDATION_FAILED = "VF";
    String DUPLICATED_EMAIL = "DE";
    String DUPLICATED_NICKNAME = "DN";
    String DUPLICATED_TEL_NUMBER = "DT";
    String DUPLICATED_PASSWORD = "DP";
    String DUPLICATED_PROFILE_COMMENT = "DC";

    String NOT_EXIST_USER = "NU";
    String NOT_EXIST_BOARD = "NB";

    String SAME_PASSWORD = "SP";
    String PASSWORD_MISSMATCH = "PM";
    String WITHDRAWAL_FAILED = "WF";
    String FIND_USER_FAILED = "FF";

    String SIGN_IN_FAILED = "SF";

    String NO_PERMISSION = "NP";

    String DATABASE_ERROR = "DBE";

}
