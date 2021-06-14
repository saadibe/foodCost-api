package com.restaurant.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorys")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryModel {

    public CategoryModel(Long id, String label){
        this.id = id;
        this.label = label;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="label", nullable = false, unique = true)
    private String label;

    @ManyToMany(mappedBy = "productCategorys")
    @JsonIgnore
    private List<ProductModel> productsList;


    @ManyToMany(mappedBy = "elementCategorys")
    @JsonIgnore
    private List<ElementModel> elementsList;
}
