package com.restaurant.demo.models.recipe;

import com.restaurant.demo.models.ConstructionModel;
import com.restaurant.demo.models.ElementModel;
import com.restaurant.demo.models.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "custom_recipe")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomRecipe {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private double grammes;
    private double gramme_price;

    @ManyToOne
    private ElementModel ingredient;

    @ManyToOne
    private ProductModel product;

    @ManyToOne
    private ConstructionModel construction;
}
