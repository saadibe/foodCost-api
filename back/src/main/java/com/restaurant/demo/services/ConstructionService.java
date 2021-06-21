package com.restaurant.demo.services;

import com.restaurant.demo.dto_models.ConstructionDto;
import com.restaurant.demo.dto_models.InvoiceDto;
import com.restaurant.demo.dto_models.ProductDto;
import com.restaurant.demo.dto_models.recipe.CustomRecipeDto;
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
        /* CODE WILL BE UPDATED view to logic change*/
        return null;
        /*  --------------------------OLD CODE---------------------
        List<ConstructionDto> constructionDtoList = new ArrayList<>();
        InvoiceModel invoiceModel = new InvoiceModel();
        invoiceModel.setCreated_at( constructionDtos.get(0).created_at );
        constructionDtos.forEach(e->{
            invoiceModel.setGlobal_discount(
                    invoiceModel.getGlobal_discount() + e.discount
            );
            invoiceModel.setOld_price(
                    invoiceModel.getOld_price() + e.old_price
            );
            invoiceModel.setFinal_price(
                    invoiceModel.getFinal_price() + e.final_price
            );
        });
        InvoiceModel invoiceRef = invoiceRepository.save( invoiceModel );

        constructionDtos.forEach(item->{
            ConstructionModel constructionModel = modelMapper.map(item, ConstructionModel.class);
            List<CustomRecipe> customRecipes = constructionModel.getCustomRecipes();
            constructionModel.setInvoice( invoiceRef );
            constructionModel = constructionRepository.save( constructionModel );
            ConstructionModel finalConstructionModel = constructionModel;
            customRecipes.forEach(e->{e.setConstruction(finalConstructionModel);});
            ConstructionDto dto = modelMapper.map( constructionRepository.save(constructionModel), ConstructionDto.class);
            constructionDtoList.add( dto );
        });

        return constructionDtoList;*/
    }

}
