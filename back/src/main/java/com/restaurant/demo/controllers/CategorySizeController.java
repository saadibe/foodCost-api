package com.restaurant.demo.controllers;

import com.restaurant.demo.dto_models.CategoryDto;
import com.restaurant.demo.dto_models.SizeCategoryDto;
import com.restaurant.demo.dto_models.SizeDto;
import com.restaurant.demo.services.CategorySizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/category-size")
public class CategorySizeController {
    @Autowired
    CategorySizeService categorySizeService;

    @GetMapping("/category")
    public List<CategoryDto> findAllCategorys(){
        return categorySizeService.findAllCategorys();
    }

    @GetMapping("/size")
    public List<SizeDto> findAllSizes(){
        return categorySizeService.findAllSizes();
    }

    @GetMapping("/mix")
    public SizeCategoryDto mixSizeCategory(){
        return categorySizeService.mixSizeCategory();
    }

    @PostMapping("/category")
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto){
        return categorySizeService.createOrUpdateCategory(categoryDto);
    }
    @PostMapping("/size")
    public SizeDto createSize(@RequestBody SizeDto sizeDto){
        return categorySizeService.createOrUpdateSize(sizeDto);
    }


    @PutMapping("/category")
    public CategoryDto updateCategory(@RequestBody CategoryDto categoryDto){
        return categorySizeService.createOrUpdateCategory(categoryDto);
    }

    @PutMapping("/size")
    public SizeDto updateSize(@RequestBody SizeDto sizeDto){
        return categorySizeService.createOrUpdateSize(sizeDto);
    }


    @DeleteMapping("/category")
    public void removeCategory(@RequestParam("id") Long id){
        categorySizeService.removeCategory(id);
    }

    @DeleteMapping("/size")
    public void removeSize(@RequestParam("id") Long id){
        categorySizeService.removeSize(id);
    }

    /*-----------------Controls------------*/

    @GetMapping("/category/{label}")
    public boolean findCategoryByLabel(@PathVariable String label){
        return categorySizeService.categoryLabelExist( label );
    }

    @GetMapping("/size/{label}")
    public boolean findSizeByLabel(@PathVariable String label){
        return categorySizeService.sizeLabelExist( label );
    }
}
