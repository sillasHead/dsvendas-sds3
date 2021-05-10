package sillashead.dsvendas.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sillashead.dsvendas.entities.Seller;

@Getter @Setter
@NoArgsConstructor
public class SaleSumDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String sellerName;
    private Double sum;

    public SaleSumDTO(Seller seller, Double sum) {
        sellerName = seller.getName();
        this.sum = sum;
    }
}
