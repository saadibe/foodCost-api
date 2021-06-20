package com.restaurant.demo.services;

import com.restaurant.demo.dto_models.ConstructionDto;
import com.restaurant.demo.dto_models.ProductDto;
import com.restaurant.demo.dto_models.recipe.CustomRecipeDto;
import com.restaurant.demo.models.ConstructionModel;
import com.restaurant.demo.models.ProductModel;
import com.restaurant.demo.models.recipe.CustomRecipe;
import com.restaurant.demo.repositorys.ConstructionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConstructionService {
    @Autowired
    ConstructionRepository constructionRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<ConstructionDto> findAll(){
        return constructionRepository.findAll()
                .stream().map(e->modelMapper.map(e, ConstructionDto.class))
        .collect(Collectors.toList());
    }

    public ConstructionDto create(ConstructionDto constructionDto){

        ConstructionModel constructionModel = modelMapper.map(constructionDto, ConstructionModel.class);
        List<CustomRecipe> customRecipes = constructionModel.getCustomRecipes();

        constructionModel = constructionRepository.save( constructionModel );
        ConstructionModel finalConstructionModel = constructionModel;

        customRecipes.forEach(e->{e.setConstruction(finalConstructionModel);});
        return modelMapper.map( constructionRepository.save(constructionModel), ConstructionDto.class);
    }

}
