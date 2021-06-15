package com.restaurant.demo.services;

import com.restaurant.demo.dto_models.ElementDto;
import com.restaurant.demo.models.ElementModel;
import com.restaurant.demo.repositorys.ElementRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ElementService {

    @Autowired
    private ElementRepository elementRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<ElementDto> findAll(){
        return elementRepository.findAll().stream()
                .map(e-> modelMapper.map(e, ElementDto.class))
                .map(this::calcTotalStock).collect(Collectors.toList());
    }


    public ElementDto createOrupdate(ElementDto elementDto){
        ElementModel elementModel = modelMapper.map(elementDto, ElementModel.class);
        return modelMapper.map( elementRepository.save(elementModel), ElementDto.class);
    }

    public void remove(Long id){
        elementRepository.deleteById( id );
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
        double percent = ( (double)100 ) / res.size();
        double stock = res.stream().mapToDouble(e -> (e) ? percent : 0.).sum();
        stock = Math.round( stock );
        element.total_stock = stock;
        return element;
    }
}
