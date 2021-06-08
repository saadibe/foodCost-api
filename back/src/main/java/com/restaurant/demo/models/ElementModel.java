package com.restaurant.demo.models;

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

    @Column(nullable = false)
    private Double kg_price;
    private Double kg_buy_price;
    private Double kg_in_stock;
    public Double gramme_price;
    private String description;
}
