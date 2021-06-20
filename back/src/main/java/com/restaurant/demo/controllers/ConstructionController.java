package com.restaurant.demo.controllers;


import com.restaurant.demo.dto_models.ConstructionDto;
import com.restaurant.demo.services.ConstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/construction")
public class ConstructionController {

    @Autowired
    ConstructionService constructionService;

    @GetMapping
    List<ConstructionDto> findAll(){ return constructionService.findAll(); }

    @PostMapping
    ConstructionDto create(@RequestBody ConstructionDto constructionDto){
        return constructionService.create( constructionDto );
    }
}
