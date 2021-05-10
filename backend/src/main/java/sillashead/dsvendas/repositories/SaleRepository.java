package sillashead.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sillashead.dsvendas.dto.SaleSuccessDTO;
import sillashead.dsvendas.dto.SaleSumDTO;
import sillashead.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new sillashead.dsvendas.dto.SaleSumDTO(s.seller, SUM(s.amount)) "
            + "FROM Sale as s GROUP BY s.seller")
    List<SaleSumDTO> amountGroupedBySeller();

    @Query("SELECT new sillashead.dsvendas.dto.SaleSuccessDTO(s.seller, SUM(s.visited), SUM(s.deals)) "
            + "FROM Sale as s GROUP BY s.seller")
    List<SaleSuccessDTO> successGroupedBySeller();
}
