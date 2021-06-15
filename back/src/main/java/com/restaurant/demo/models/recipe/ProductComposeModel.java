package com.restaurant.demo.models.recipe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restaurant.demo.models.ElementModel;
import com.restaurant.demo.models.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_recipe")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductComposeModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ElementModel ingredient;

    @Column(nullable = false)
    private double grammes;

    @ManyToMany(mappedBy = "recipe")
    private List<ProductModel> product_to_make;

}
