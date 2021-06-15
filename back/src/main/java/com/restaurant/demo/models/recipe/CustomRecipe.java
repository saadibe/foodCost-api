package com.restaurant.demo.models.recipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "custom_recipe")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomRecipe {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
}
