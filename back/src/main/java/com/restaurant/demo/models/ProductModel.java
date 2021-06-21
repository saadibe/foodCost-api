package com.restaurant.demo.models;

import com.restaurant.demo.models.recipe.CustomRecipe;
import com.restaurant.demo.models.recipe.ProductComposeModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String type;

    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Double actual_price;

    @Column(nullable = false)
    private Integer discount = 0;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String image;

    public Integer popularity = 0;

    public Integer rating = 0;

    public Integer saled_times = 0;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "products_categorys",
            joinColumns = @JoinColumn(name = "product"),
            inverseJoinColumns = @JoinColumn(name = "category")
    )
    private List<CategoryModel> productCategorys;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "products_size",
            joinColumns = @JoinColumn(name = "product"),
            inverseJoinColumns = @JoinColumn(name = "size")
    )
    private List<SizeCommodityModel>productSizes;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "products_items_recipe",
            joinColumns = @JoinColumn(name = "product"),
            inverseJoinColumns = @JoinColumn(name = "recipe_item")
    )
    private List<ProductComposeModel> recipe;


    @OneToMany(mappedBy = "product", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<CustomRecipe> custom_recipe;
}
