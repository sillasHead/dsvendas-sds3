package sillashead.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sillashead.dsvendas.dto.SellerDTO;
import sillashead.dsvendas.entities.Seller;
import sillashead.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {

    @Autowired
    private SellerRepository repository;

    @Autowired
    private ModelMapper modelMapper;
    
    public List<SellerDTO> findAll() {
        List<Seller> sellers = repository.findAll();
        return sellers.stream().map(seller ->
            modelMapper.map(seller, SellerDTO.class)
        ).collect(Collectors.toList());
    }
}
