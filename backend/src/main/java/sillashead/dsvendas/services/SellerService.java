package sillashead.dsvendas.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sillashead.dsvendas.dto.SellerDTO;
import sillashead.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {

    @Autowired
    private SellerRepository repository;

    @Autowired
    private ModelMapper modelMapper;
    
    public List<SellerDTO> findAll() {
        List<SellerDTO> sellers = new ArrayList<>();
        repository.findAll().forEach(seller -> 
            sellers.add(modelMapper.map(seller, SellerDTO.class))
        );
        return sellers;
    }
}
