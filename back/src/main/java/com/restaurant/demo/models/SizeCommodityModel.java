package com.restaurant.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "size_commodity")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SizeCommodityModel {

    public SizeCommodityModel(Long id, String label){
        this.id = id;
        this.label = label;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "label", nullable = false, unique = true)
    private String label;

    @ManyToMany(mappedBy = "productSizes")
    @JsonIgnore
    private List<ProductModel> productsList;
}
