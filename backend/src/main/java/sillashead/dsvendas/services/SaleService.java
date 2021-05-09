package sillashead.dsvendas.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sillashead.dsvendas.dto.SaleDTO;
import sillashead.dsvendas.repositories.SaleRepository;
import sillashead.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
    
    @Autowired
    private SaleRepository repository;
    
    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private ModelMapper modelMapper;
    
    //§ garante que toda a operacao com o bd seja resolvida neste momento no service
    //e o readOnly eh para que nao seja feito o lock de escrita no bd
    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll(); 
        //§ trazer os vendedores em memoria para a jpa armazena-los cache para quando 
        //a busca das vendas que dependem dos vendedores, eles ja estarao em memoria
        List<SaleDTO> sales = new ArrayList<>();
        repository.findAll(pageable).forEach(sale -> 
            sales.add(modelMapper.map(sale, SaleDTO.class))
        );
        return new PageImpl<>(sales);
    }
}
