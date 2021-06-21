package com.restaurant.demo.services;

import com.restaurant.demo.dto_models.ConstructionDto;
import com.restaurant.demo.dto_models.InvoiceDto;
import com.restaurant.demo.dto_models.ProductDto;
import com.restaurant.demo.dto_models.recipe.CustomRecipeDto;
import com.restaurant.demo.dto_models.refrence.InvoiceRefDto;
import com.restaurant.demo.models.ConstructionModel;
import com.restaurant.demo.models.InvoiceModel;
import com.restaurant.demo.models.ProductModel;
import com.restaurant.demo.models.recipe.CustomRecipe;
import com.restaurant.demo.repositorys.ConstructionRepository;
import com.restaurant.demo.repositorys.InvoiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConstructionService {
    @Autowired
    ConstructionRepository constructionRepository;

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<ConstructionDto> findAll(){
        return constructionRepository.findAll()
                .stream().map(e->modelMapper.map(e, ConstructionDto.class))
        .collect(Collectors.toList());
    }

    public InvoiceDto createAsInvoice(InvoiceDto invoiceDto){
        List<ConstructionDto> constructions = new ArrayList<>(invoiceDto.constructions);
        invoiceDto.constructions.clear();
        InvoiceModel invoiceModel = modelMapper.map( invoiceDto, InvoiceModel.class);
        invoiceModel = invoiceRepository.save( invoiceModel );
        InvoiceModel effectiveInvoice = invoiceModel;
        constructions.forEach(e->{
            e.setInvoice( new InvoiceRefDto(effectiveInvoice.getId()) );
        });
        List<ConstructionModel> constructionModels = constructions.stream().map(e->{
                e.invoice = new InvoiceRefDto(effectiveInvoice.getId() );
                return modelMapper.map(e, ConstructionModel.class);
        }).collect(Collectors.toList());
        invoiceModel.setConstructions( constructionModels );
        InvoiceDto resultDto = modelMapper.map( invoiceRepository.save( invoiceModel ), InvoiceDto.class );
        return resultDto;
    }

}
