package com.restaurant.demo.controllers;


import com.restaurant.demo.dto_models.InvoiceDto;
import com.restaurant.demo.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping
    public List<InvoiceDto> findAll(){ return this.invoiceService.findAll(); }

    @GetMapping("/{id}")
    public InvoiceDto findById(@PathVariable Long id){ return invoiceService.findById(id); }

}
