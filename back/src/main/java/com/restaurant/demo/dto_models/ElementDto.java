package com.restaurant.demo.dto_models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurant.demo.dto_models.recipe.RecipeElementDto;
import com.restaurant.demo.models.CategoryModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ElementDto implements Serializable {
    public Long id;
    public String name;
    public List<CategoryModel> elementCategorys;
    public List<RecipeElementDto> recipe;
    public String image;
    public Double kg_price;
    public Double gramme_price;
    public Double kg_buy_price;
    public Double kg_in_stock;
    public String description;
}
