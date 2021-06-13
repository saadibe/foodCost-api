package com.restaurant.demo.components;

import com.restaurant.demo.models.CategoryModel;
import com.restaurant.demo.models.SizeCommodityModel;
import com.restaurant.demo.repositorys.CategorysRepository;
import com.restaurant.demo.repositorys.SizeCommodityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BeansComponents {
    @Autowired
    CategorysRepository categorysRepository;

    @Autowired
    SizeCommodityRepository sizeRepository;


    @Bean(name="modelmapper")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void makeAfterInit() {

        categorysRepository.saveAllAndFlush(Arrays.asList(
                new CategoryModel( (long) 1, "small"),
                new CategoryModel( (long) 2, "medium"),
                new CategoryModel( (long) 3, "large")
        ));

        sizeRepository.saveAllAndFlush( Arrays.asList(
                new SizeCommodityModel( (long)1, "Salée" ),
                new SizeCommodityModel( (long)2, "Boisson" ),
                new SizeCommodityModel( (long)3, "Dessert" )
        ));
    }
}
