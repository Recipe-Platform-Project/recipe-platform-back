package com.recipe.recipe_back.entity.primaryKey;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscirbePk implements Serializable{

    @Column(name="to_user")
    private String toUser;

    @Column(name="from_user")
    private String fromUser;
    
}
