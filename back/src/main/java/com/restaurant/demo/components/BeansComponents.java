package com.restaurant.demo.components;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeansComponents {
    @Bean(name="modelmapper")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
