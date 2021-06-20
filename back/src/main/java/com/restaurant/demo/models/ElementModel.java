package com.restaurant.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restaurant.demo.models.recipe.CustomRecipe;
import com.restaurant.demo.models.recipe.ElementComposeModel;
import com.restaurant.demo.models.recipe.ProductComposeModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "elements")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ElementModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String image;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "elements_categorys",
            joinColumns = @JoinColumn(name = "element"),
            inverseJoinColumns = @JoinColumn(name = "category")
    )
    private List<CategoryModel> elementCategorys;

    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProductComposeModel> elementsNeededInProduct;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "elements_items_recipe",
            joinColumns = @JoinColumn(name = "element"),
            inverseJoinColumns = @JoinColumn(name = "recipe_item")
    )
    private List<ElementComposeModel> recipe;

    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ElementComposeModel> ingredients;


    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CustomRecipe> construct_recipe;



    @Column(nullable = false)
    private Double kg_price;

    private Double kg_buy_price;
    private Double kg_in_stock;
    public Double gramme_price;
    private String description;
}
