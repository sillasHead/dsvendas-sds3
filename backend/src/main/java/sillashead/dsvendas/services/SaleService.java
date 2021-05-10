package sillashead.dsvendas.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sillashead.dsvendas.dto.SaleDTO;
import sillashead.dsvendas.dto.SaleSuccessDTO;
import sillashead.dsvendas.dto.SaleSumDTO;
import sillashead.dsvendas.entities.Sale;
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
        Page<Sale> sales = repository.findAll(pageable);
        return sales.map(sale -> 
            modelMapper.map(sale, SaleDTO.class)
        );
    }

    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupedBySeller() {
        return repository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> successGroupedBySeller() {
        return repository.successGroupedBySeller();
    }
}
