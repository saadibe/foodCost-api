package com.restaurant.demo.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
/*
@Entity
@Table(name = "construction")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter*/
public class ConstructionModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product")
    ProductModel product;

    // not finished ...
}
