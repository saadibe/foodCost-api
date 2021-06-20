package com.restaurant.demo.dto_models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.restaurant.demo.dto_models.recipe.CustomRecipeDto;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConstructionDto implements Serializable {

    public Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING)
    public LocalDateTime created_at;

    public String label;
    public String qrcode = "";
    public double final_price;
    public double discount = 0;
    public List<CustomRecipeDto> customRecipes;

}
