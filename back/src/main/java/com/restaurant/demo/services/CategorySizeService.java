package com.restaurant.demo.services;

import com.restaurant.demo.dto_models.CategoryDto;
import com.restaurant.demo.dto_models.SizeCategoryDto;
import com.restaurant.demo.dto_models.SizeDto;
import com.restaurant.demo.models.CategoryModel;
import com.restaurant.demo.models.SizeCommodityModel;
import com.restaurant.demo.repositorys.CategorysRepository;
import com.restaurant.demo.repositorys.SizeCommodityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategorySizeService {

    @Autowired
    private CategorysRepository categorysRepository;
    @Autowired
    private SizeCommodityRepository sizeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public SizeCategoryDto mixSizeCategory(){
        SizeCategoryDto sizeCategoryDto = new SizeCategoryDto();
        sizeCategoryDto.categorys = categorysRepository.findAll();
        sizeCategoryDto.sizes = sizeRepository.findAll();
        return sizeCategoryDto;
    }

    public List<CategoryDto> findAllCategorys(){
        return categorysRepository.findAll().stream()
                .map(e->modelMapper.map(e, CategoryDto.class))
                .collect(Collectors.toList());
    }

    public List<SizeDto> findAllSizes(){
        return sizeRepository.findAll().stream().map(e->modelMapper.map(e, SizeDto.class))
                .collect(Collectors.toList());
    }

    public CategoryDto createOrUpdateCategory(CategoryDto categoryDto){
        return modelMapper.map(
                categorysRepository.save( modelMapper.map(categoryDto, CategoryModel.class) ),
                CategoryDto.class
        );
    }

    public SizeDto createOrUpdateSize(SizeDto sizeDto){
        return modelMapper.map(
                sizeRepository.save( modelMapper.map(sizeDto, SizeCommodityModel.class) ),
                SizeDto.class
        );
    }

    public void removeCategory(Long id){
        categorysRepository.deleteById( id );
    }

    public void removeSize(Long id){
        sizeRepository.deleteById( id );
    }


    public boolean categoryLabelExist(String label){
        return categorysRepository.findCategoryByLabel(label) != null;
    }

    public boolean sizeLabelExist(String label){
        return sizeRepository.findSizeByLabel(label) != null;
    }

}
