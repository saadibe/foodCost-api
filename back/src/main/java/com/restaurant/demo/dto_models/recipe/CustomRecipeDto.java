package com.restaurant.demo.dto_models.recipe;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomRecipeDto implements Serializable {

    public Long id;
    public double grammes;
    public double gramme_price;
    public CustomComposerDto ingredient;
    public CustomComposerDto product;
}
