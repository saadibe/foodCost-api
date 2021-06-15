package com.restaurant.demo.controllers;

import com.restaurant.demo.dto_models.ProductDto;
import com.restaurant.demo.dto_models.SizeCategoryDto;
import com.restaurant.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productsService;

    @GetMapping
    public List<ProductDto> findAll(){
        return productsService.findAll();
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto){
        return this.productsService.createOrupdate(productDto);
    }

    @PutMapping
    public ProductDto update(@RequestBody ProductDto productDto){
        return this.productsService.createOrupdate(productDto);
    }

    @DeleteMapping
    public void remove(@RequestParam("id") Long id){
        this.productsService.remove( id );
    }


}
