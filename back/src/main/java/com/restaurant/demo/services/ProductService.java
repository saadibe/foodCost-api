package com.restaurant.demo.services;

import com.restaurant.demo.components.StaticTools;
import com.restaurant.demo.dto_models.ProductDto;
import com.restaurant.demo.dto_models.SizeCategoryDto;
import com.restaurant.demo.models.ElementModel;
import com.restaurant.demo.models.ProductModel;
import com.restaurant.demo.models.recipe.ProductComposeModel;
import com.restaurant.demo.repositorys.CategorysRepository;
import com.restaurant.demo.repositorys.ProductRepository;
import com.restaurant.demo.repositorys.SizeCommodityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
            Random ran = new Random();
            productDto = calcTotalStock( productDto );
            list.add( productDto );
        });
        return list;
    }

    public ProductDto create(ProductDto productDto){
        ProductModel productModel = new ProductModel();

        modelMapper.map(productDto, productModel);
        ProductModel res = productRepository.save(productModel);
        modelMapper.map(res, productDto);
        return (productDto.recipe.size()>0)?this.update(productDto): productDto;
    }

    public ProductDto update(ProductDto productDto){
        ProductModel productModel = productRepository.getById(productDto.id);
        StaticTools.copyNonNullProperties(productDto, productModel);
        productModel = setProductRecipe(productDto, productModel);
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

    private ProductModel setProductRecipe(ProductDto productDto, ProductModel productModel){
        List<ProductComposeModel> new_recipe = new ArrayList<>();
        productDto.recipe.forEach( recipe_item->{
            ProductComposeModel pcm = new ProductComposeModel();
            ElementModel element = new ElementModel();
            element.setId( recipe_item.ingredient.id );
            pcm.setGrammes( recipe_item.getGrammes() );
            pcm.setIngredient( element );
            pcm.setProduct_to_make( productModel );
            new_recipe.add( pcm );
        });

        productRepository.clearRecipeList(productModel.getId());
        productModel.setRecipe( new_recipe );
        return productModel;
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
        double percent = 100 / res.size();
        double stock = res.stream().mapToDouble(e -> (e) ? percent : 0.).sum();
        stock = Math.round( stock );
        System.out.println( stock );
        product.total_stock = stock;
        return product;
    }
}
