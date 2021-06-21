package com.restaurant.demo.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.restaurant.demo.models.recipe.CustomRecipe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Entity
@Table(name = "construction")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConstructionModel {
    public ConstructionModel(Long id){ this.id = id; }
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String label;
    private double old_price;
    private double final_price;

    private double discount;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "construction", orphanRemoval = true)
    private List<CustomRecipe> customRecipes;

    @ManyToOne
    private InvoiceModel invoice;

}
