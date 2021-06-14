package com.restaurant.demo.services;

import com.restaurant.demo.components.StaticTools;
import com.restaurant.demo.dto_models.ElementDto;
import com.restaurant.demo.dto_models.ProductDto;
import com.restaurant.demo.models.ElementModel;
import com.restaurant.demo.models.ProductModel;
import com.restaurant.demo.models.recipe.ElementComposeModel;
import com.restaurant.demo.models.recipe.ProductComposeModel;
import com.restaurant.demo.repositorys.ElementRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElementService {

    @Autowired
    private ElementRepository elementRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<ElementDto> findAll(){
        List<ElementDto> list = new ArrayList<>();
        elementRepository.findAll().forEach(element->{
            ElementDto elementDto = new ElementDto();
            modelMapper.map(element, elementDto);
            elementDto = calcTotalStock( elementDto );
            list.add( elementDto );
        });
        return list;
    }

    public ElementDto create(ElementDto elementDto){
        ElementModel elementModel = new ElementModel();
        modelMapper.map(elementDto, elementModel);
        ElementModel res = elementRepository.save(elementModel);
        modelMapper.map(res, elementDto);
        return (elementDto.recipe.size() > 0)?this.update( elementDto ):elementDto;
    }

    public ElementDto update(ElementDto elementDto){
        ElementModel elementModel = elementRepository.getById(elementDto.id);
        StaticTools.copyNonNullProperties(elementDto, elementModel);
        elementModel = setElementRecipe(elementDto, elementModel);
        ElementModel newElement = elementRepository.save( elementModel );
        modelMapper.map(newElement, elementDto);
        return elementDto;
    }

    public void remove(Long id){
        elementRepository.deleteById( id );
    }


    private ElementModel setElementRecipe(ElementDto elementDto, ElementModel elementModel){
        List<ElementComposeModel> new_recipe = new ArrayList<>();
        elementDto.recipe.forEach( recipe_item->{
            ElementComposeModel pcm = new ElementComposeModel();
            ElementModel element = new ElementModel();
            element.setId( recipe_item.ingredient.id );
            pcm.setGrammes( recipe_item.getGrammes() );
            pcm.setIngredient( element );
            pcm.setTo_make( elementModel );
            new_recipe.add( pcm );
        });

        elementRepository.clearRecipeList(elementModel.getId());
        elementModel.setRecipe( new_recipe );
        return elementModel;
    }

    ElementDto calcTotalStock(ElementDto element){
        if( element.recipe.size() == 0 ){
            element.total_stock = -1.;
            return element;
        }
        List<Boolean> res = new ArrayList<>();
        element.recipe.forEach(e->{
            res.add( (e.grammes / 1000) <= e.ingredient.kg_in_stock );
        });
        double percent = 100 / res.size();
        double stock = res.stream().mapToDouble(e -> (e) ? percent : 0.).sum();
        stock = Math.round( stock );
        element.total_stock = stock;
        return element;
    }
}
