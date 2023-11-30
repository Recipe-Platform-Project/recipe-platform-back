// package com.recipe.recipe_back.dto.response.board;

// import java.util.List;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;

// import com.recipe.recipe_back.common.object.MaterialCategoriesListItem;
// import com.recipe.recipe_back.common.object.MaterialListItem;
// import com.recipe.recipe_back.common.object.RecipeWriteSequenceListItem;
// import com.recipe.recipe_back.dto.response.ResponseCode;
// import com.recipe.recipe_back.dto.response.ResponseMessage;
// import com.recipe.recipe_back.dto.response.ResponseDto;
// import com.recipe.recipe_back.entity.BoardEntity;
// import com.recipe.recipe_back.entity.MaterialCategoriesEntity;
// import com.recipe.recipe_back.entity.MaterialEntity;
// import com.recipe.recipe_back.entity.RecipeWriteSequenceEntity;

// import lombok.Getter;

// @Getter
// public class GetBoardResponseDto extends ResponseDto {
// private int boardNumber;
// private String userEmail;
// private String boardMainImage;
// private String writerProfileImage;
// private String writerNickname;
// private String title;
// private String introduce;
// private List<RecipeWriteSequenceListItem> recipeWriteSequence;
// private String writeDateTime;
// private int viewCount;
// private int commentCount;
// private int favoriteCount;
// private String videoLink;
// private String cookingTip;
// private String requiredTime;
// private String difficulty;
// private String peopleCount;
// private String subscirbe;
// private List<MaterialCategoriesListItem> materialCategoriesSequence;
// private List<MaterialListItem> mainMaterialFK;

// private GetBoardResponseDto(String code, String message, BoardEntity
// boardEntity,
// List<RecipeWriteSequenceEntity> recipeWriteSequenceEntities,
// List<MaterialCategoriesEntity> materialCategoriesEntities,
// List<MaterialEntity> materialEntities) {
// super(code, message);

// this.boardMainImage = boardEntity.getBoardMainImage();
// this.boardNumber = boardEntity.getBoardNumber();
// this.writerProfileImage = boardEntity.getWriterProfileImage();
// this.writerNickname = boardEntity.getWriterNickname();
// this.title = boardEntity.getTitle();
// this.introduce = boardEntity.getIntroduce();
// this.recipeWriteSequence =
// RecipeWriteSequenceListItem.getList(recipeWriteSequenceEntities);
// this.writeDateTime = boardEntity.getWriteDatetime();
// this.viewCount = boardEntity.getViewCount();
// this.commentCount = boardEntity.getCommentCount();
// this.favoriteCount = boardEntity.getFavoriteCount();
// this.videoLink = boardEntity.getVideoLink();
// this.cookingTip = boardEntity.getCookingTip();
// this.requiredTime = boardEntity.getRequiredTime();
// this.difficulty = boardEntity.getDifficulty();
// this.peopleCount = boardEntity.getPeopleCount();
// this.subscirbe = boardEntity.getSubscirbe();
// this.materialCategoriesSequence =
// MaterialCategoriesListItem.getList(materialCategoriesEntities);
// this.mainMaterialFK = MaterialListItem.getList(materialEntities);
// }

// public static ResponseEntity<GetBoardResponseDto> success(BoardEntity
// boardEntity,
// List<RecipeWriteSequenceEntity> recipeWriteSequenceEntities,
// List<MaterialCategoriesEntity> materialCategoriesEntities,
// List<MaterialEntity> materialEntities) {
// GetBoardResponseDto result = new GetBoardResponseDto(ResponseCode.SUCCESS,
// ResponseMessage.SUCCESS, boardEntity,
// recipeWriteSequenceEntities, materialCategoriesEntities, materialEntities);
// return ResponseEntity.status(HttpStatus.OK).body(result);
// }

// public static ResponseEntity<ResponseDto> notExistBoard() {
// ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_BOARD,
// ResponseMessage.NOT_EXIST_BOARD);
// return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
// }
// }
