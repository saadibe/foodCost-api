package com.restaurant.demo.dto_models.recipe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeDto implements Serializable {
    public Long id;
    public Double grammes;
    public RecipeIngredientDto ingredient;
}