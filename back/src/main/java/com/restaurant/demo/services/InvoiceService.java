package com.restaurant.demo.services;

import com.restaurant.demo.dto_models.InvoiceDto;
import com.restaurant.demo.repositorys.InvoiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<InvoiceDto> findAll(){
      return invoiceRepository.findAll().stream()
              .map(e->modelMapper.map(e, InvoiceDto.class)).collect(Collectors.toList());
    }

    public InvoiceDto findById(Long id){
        return modelMapper.map( invoiceRepository.findById(id).get(), InvoiceDto.class );
    }

}
