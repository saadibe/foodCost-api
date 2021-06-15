package com.restaurant.demo.services;

import com.restaurant.demo.dto_models.ProductDto;
import com.restaurant.demo.models.ProductModel;
import com.restaurant.demo.repositorys.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductDto> findAll(){
        return productRepository.findAll().stream()
                .map(e-> modelMapper.map(e, ProductDto.class))
                .map(this::calcTotalStock).collect(Collectors.toList());
    }

    public ProductDto createOrupdate(ProductDto productDto){
        ProductModel productModel = modelMapper.map(productDto, ProductModel.class);
        return modelMapper.map( productRepository.save(productModel), ProductDto.class);
    }

    public void remove(Long id){
        productRepository.deleteById( id );
    }

    ProductDto calcTotalStock(ProductDto product){

        if( product.recipe.size() == 0 ){
            product.total_stock = -1.;
            return product;
        }
        List<Boolean> res = new ArrayList<>();
        product.recipe.forEach(e->{
            res.add( (e.grammes / 1000) <= e.ingredient.kg_in_stock );
        });

        double percent = ( (double) 100 )/ res.size();
        double stock = res.stream().mapToDouble(e -> (e) ? percent : 0.).sum();
        stock = Math.round( stock );
        product.total_stock = stock;
        return product;
    }
}
