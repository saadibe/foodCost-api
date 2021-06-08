package com.restaurant.demo.dto_models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class SizeCategoryDto implements Serializable {
    public List<CategoryModel> categorys = new ArrayList<>();
    public List<SizeCommodityModel> sizes = new ArrayList<>();
}
