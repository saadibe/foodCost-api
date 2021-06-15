package com.restaurant.demo.dto_models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.restaurant.demo.dto_models.recipe.RecipeDto;
import com.restaurant.demo.models.CategoryModel;
import com.restaurant.demo.models.SizeCommodityModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto implements Serializable {
    public Long id;
    public String name;
    public String type;
    public String description;
    public Double total_stock;
    public Double price;
    public Double actual_price;
    public Integer discount;
    public Integer popularity;
    public Integer rating;
    public Integer saled_times;
    public String image;
    public Set<RecipeDto> recipe;
    public List<CategoryModel> productCategorys = new ArrayList<>();
    public List<SizeCommodityModel>productSizes = new ArrayList<>();
}
