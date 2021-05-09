package sillashead.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sillashead.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    
}
