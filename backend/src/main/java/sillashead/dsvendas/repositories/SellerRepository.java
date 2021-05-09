package sillashead.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sillashead.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    
}
