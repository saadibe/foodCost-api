package com.restaurant.demo.dto_models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.restaurant.demo.dto_models.recipe.CustomRecipeDto;
import com.restaurant.demo.dto_models.refrence.InvoiceRefDto;
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

    public String label;
    public double old_price;
    public double final_price;
    public double discount = 0;
    public List<CustomRecipeDto> customRecipes;

    public InvoiceRefDto invoice;

}
