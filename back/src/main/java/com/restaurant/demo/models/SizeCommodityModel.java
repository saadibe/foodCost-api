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
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String label = "Size";

    @ManyToMany(mappedBy = "productSizes")
    @JsonIgnore
    private List<ProductModel> productsList;
}
