package com.restaurant.demo.services;

import com.restaurant.demo.components.StaticTools;
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
        List<CategoryDto> list = new ArrayList<>();
        categorysRepository.findAll().forEach(category->{
            CategoryDto categoryDto = new CategoryDto();
            modelMapper.map(category, categoryDto);
            list.add( categoryDto );
        });
        return list;
    }

    public List<SizeDto> findAllSizes(){
        List<SizeDto> list = new ArrayList<>();
        sizeRepository.findAll().forEach(size->{
            SizeDto sizeDto = new SizeDto();
            modelMapper.map(size, sizeDto);
            list.add( sizeDto );
        });
        return list;
    }

    public CategoryDto createCategory(CategoryDto categoryDto){
        CategoryModel elementModel = new CategoryModel();
        modelMapper.map(categoryDto, elementModel);
        CategoryModel res = categorysRepository.save(elementModel);
        modelMapper.map(res, categoryDto);
        return categoryDto;
    }

    public SizeDto createSize(SizeDto sizeDto){
        SizeCommodityModel sizeModel = new SizeCommodityModel();
        modelMapper.map(sizeDto, sizeModel);
        SizeCommodityModel res = sizeRepository.save(sizeModel);
        modelMapper.map(res, sizeDto);
        return sizeDto;
    }


    public CategoryDto updateCategory(CategoryDto categoryDto){
        CategoryModel categoryModel = categorysRepository.getById(categoryDto.id);
        StaticTools.copyNonNullProperties(categoryDto, categoryModel);
        CategoryModel newCategory = categorysRepository.save( categoryModel );
        modelMapper.map(newCategory, categoryDto);
        return categoryDto;
    }
    public SizeDto updateSize(SizeDto sizeDto){
        SizeCommodityModel sizeModel = sizeRepository.getById(sizeDto.id);
        StaticTools.copyNonNullProperties(sizeDto, sizeModel);
        SizeCommodityModel newSize = sizeRepository.save( sizeModel );
        modelMapper.map(newSize, sizeDto);
        return sizeDto;
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
