package com.restaurant.demo.controllers;


import com.restaurant.demo.dto_models.ConstructionDto;
import com.restaurant.demo.dto_models.InvoiceDto;
import com.restaurant.demo.repositorys.InvoiceRepository;
import com.restaurant.demo.services.ConstructionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/construction")
public class ConstructionController {

    @Autowired
    ConstructionService constructionService;

    @GetMapping
    List<ConstructionDto> findAll(){ return constructionService.findAll(); }

    @PostMapping("/as-invoice")
    InvoiceDto create(@RequestBody InvoiceDto invoiceDto){
        return constructionService.createAsInvoice( invoiceDto );
    }
}
