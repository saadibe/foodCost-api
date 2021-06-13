package com.restaurant.demo.dto_models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurant.demo.dto_models.recipe.RecipeProductDto;
import com.restaurant.demo.models.CategoryModel;
import com.restaurant.demo.models.SizeCommodityModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto implements Serializable {
    public Long id;
    public String name;
    public String type;
    public String description;
    public Integer total_stock;
    public Double price;
    public Double actual_price;
    public Integer discount;
    public Integer popularity;
    public Integer rating;
    public Integer saled_times;
    public String image;
    public List<RecipeProductDto> recipe;
    public List<CategoryModel> productCategorys = new ArrayList<>();
    public List<SizeCommodityModel>productSizes = new ArrayList<>();
}
