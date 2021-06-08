package com.restaurant.demo.services;

import com.restaurant.demo.components.StaticTools;
import com.restaurant.demo.dto_models.ElementDto;
import com.restaurant.demo.models.ElementModel;
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
            list.add( elementDto );
        });
        return list;
    }

    public ElementDto create(ElementDto elementDto){
        ElementModel elementModel = new ElementModel();
        modelMapper.map(elementDto, elementModel);
        ElementModel res = elementRepository.save(elementModel);
        modelMapper.map(res, elementDto);
        return elementDto;
    }

    public ElementDto update(ElementDto elementDto){
        ElementModel elementModel = elementRepository.getById(elementDto.id);
        StaticTools.copyNonNullProperties(elementDto, elementModel);
        ElementModel newElement = elementRepository.save( elementModel );
        modelMapper.map(newElement, elementDto);
        return elementDto;
    }

    public void remove(Long id){
        elementRepository.deleteById( id );
    }
}
