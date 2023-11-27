package com.recipe.recipe_back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.recipe.recipe_back.entity.primaryKey.SubscirbePk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="subscirbe")
@Table(name="subscirbe")
@IdClass(SubscirbePk.class)
public class SubscirbeEntity {

    @Id
    private String toUser;
    @Id
    private String fromUser;

}
