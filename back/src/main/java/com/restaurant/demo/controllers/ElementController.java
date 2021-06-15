package com.restaurant.demo.controllers;

import com.restaurant.demo.dto_models.ElementDto;
import com.restaurant.demo.repositorys.ElementRepository;
import com.restaurant.demo.services.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/elements")
public class ElementController {

    @Autowired
    ElementService elementService;

    @Autowired
    ElementRepository xx;
    @GetMapping
    public List<ElementDto> findAll(){
        return elementService.findAll();
    }

    @PostMapping
    public ElementDto create(@RequestBody ElementDto elementDto){
        return this.elementService.createOrupdate(elementDto);
    }

    @PutMapping
    public ElementDto update(@RequestBody ElementDto elementDto){
        return this.elementService.createOrupdate(elementDto);
    }

    @DeleteMapping
    public void remove(@RequestParam("id") Long id){
        this.elementService.remove( id );
    }
}
