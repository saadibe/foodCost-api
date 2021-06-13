package com.restaurant.demo.models.recipe;


import com.restaurant.demo.models.ElementModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "element_recipe")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ElementComposeModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "element")
    private ElementModel to_make;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ElementModel ingredient;

    @Column(nullable = false)
    private double grammes;

}
