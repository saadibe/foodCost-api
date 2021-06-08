package com.restaurant.demo.services;

import com.restaurant.demo.components.StaticTools;
import com.restaurant.demo.dto_models.ProductDto;
import com.restaurant.demo.dto_models.SizeCategoryDto;
import com.restaurant.demo.models.ProductModel;
import com.restaurant.demo.repositorys.CategorysRepository;
import com.restaurant.demo.repositorys.ProductRepository;
import com.restaurant.demo.repositorys.SizeCommodityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategorysRepository categorysRepository;
    @Autowired
    private SizeCommodityRepository sizeCommodityRepository;


    @Autowired
    private ModelMapper modelMapper;

    public List<ProductDto> findAll(){
        List<ProductDto> list = new ArrayList<>();
        productRepository.findAll().forEach(product->{
            ProductDto productDto = new ProductDto();
            modelMapper.map(product, productDto);
            list.add( productDto );
        });
        return list;
    }

    public ProductDto create(ProductDto productDto){
        ProductModel productModel = new ProductModel();
        modelMapper.map(productDto, productModel);
        ProductModel res = productRepository.save(productModel);
        modelMapper.map(res, productDto);
        return productDto;
    }

    public ProductDto update(ProductDto productDto){
        ProductModel productModel = productRepository.getById(productDto.id);
        StaticTools.copyNonNullProperties(productDto, productModel);
        ProductModel newProduct = productRepository.save( productModel );
        modelMapper.map(newProduct, productDto);
        return productDto;
    }

    public void remove(Long id){
        productRepository.deleteById( id );
    }

    public SizeCategoryDto findSizeCategory(){
        SizeCategoryDto sizeCategoryDto = new SizeCategoryDto();
        sizeCategoryDto.categorys = categorysRepository.findAll();
        sizeCategoryDto.sizes = sizeCommodityRepository.findAll();
        return sizeCategoryDto;
    }
}
