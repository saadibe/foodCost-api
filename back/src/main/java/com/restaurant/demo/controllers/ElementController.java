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
        /*ElementModel m = new ElementModel();
        m.setId((long)1);
        ElementModel m2 = new ElementModel();
        m2.setId((long)3);
        ElementComposeModel e = new ElementComposeModel();
        e.setGrammes(15);
        e.setElement_need( m );
        e.setElement_to_make( m2 );
        List<ElementComposeModel> ss = m.getRecipe();
        ss.add(e);
        m.setRecipe( ss );
        xx.save( m );*/
        return elementService.findAll();
    }

    @PostMapping
    public ElementDto create(@RequestBody ElementDto elementDto){
        return this.elementService.create(elementDto);
    }

    @PutMapping
    public ElementDto update(@RequestBody ElementDto elementDto){
        return this.elementService.update(elementDto);
    }

    @DeleteMapping
    public void remove(@RequestParam("id") Long id){
        this.elementService.remove( id );
    }
}
