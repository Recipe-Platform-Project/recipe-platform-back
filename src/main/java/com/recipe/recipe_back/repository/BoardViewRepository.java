package com.recipe.recipe_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.recipe.recipe_back.entity.BoardViewEntity;

@Repository
public interface BoardViewRepository extends JpaRepository<BoardViewEntity, Integer> {

    BoardViewEntity findByBoardNumber(Integer boardNumber);

    List<BoardViewEntity> findTop3ByOrderByFavoriteCountDesc();

    List<BoardViewEntity> findTop12ByOrderByWriteDatetimeDesc();

    List<BoardViewEntity> findTop12ByKindCategoryOrderByFavoriteCountDesc(String category);

   @Query(
    value=
    "SELECT * " +
    "FROM board_view " +
    "WHERE (title LIKE %?1% OR board_content LIKE %?1%) " +
    "AND kind_category LIKE %?2% " +
    "AND way_category LIKE %?3% " +
    "AND material_category LIKE %?4% ",
    nativeQuery = true
)
   List<BoardViewEntity> getCatagorySeachList(String searchWord, String kind, String way, String matrial);

   @Query(
   value=
   "SELECT " +
   " B.board_number AS board_number, " +
   " B.title AS title, " +
   " B.introduce AS introduce, " +
   " B.board_content AS board_content, " +
   " B.board_main_image AS board_main_image, " +
   " B.favorite_count AS favorite_count, " +
   " B.kind_category AS kind_category, " +
   " B.way_category AS way_category, " +
   " B.material_category AS material_category, " +
   " B.comment_count AS comment_count, " +
   " IFNULL(C.star_rating, '0') AS star_rating, " +
   " U.nickname AS writer_nickname, " +
   " U.profile_image_url AS writer_profile_image, " +
   " B.view_count AS view_count, " +
   " B.user_email AS writer_email, " +
   " B.write_datetime AS write_datetime, " +
   " T.recipe_tag_list AS recipe_tag_list " +
   " FROM board AS B " +
   " LEFT JOIN user U " +
   " ON B.user_email = U.email " +
   " LEFT JOIN( " +
   "     SELECT board_number, AVG(rating) AS star_rating " +
   "     FROM comment " +
   "     WHERE write_datetime BETWEEN ?1 AND ?2 " +
   "     GROUP BY board_number " +
   " ) AS C " +
   " ON B.board_number = C.board_number " +
   " LEFT JOIN ( " +
   "    SELECT board_number, recipe_tag_list " +
   "    FROM recipe_tag " +
   "    GROUP BY board_number " +
   ") AS T " +
   " ON B.board_number = T.board_number " +
   " ORDER BY view_count DESC " +
   " LIMIT 50 ",
   nativeQuery =true
   )
   List<BoardViewEntity> getRankingViewCountList(String startDate, String endDate);
   
}
