package sillashead.dsvendas.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sillashead.dsvendas.entities.Seller;

@Getter @Setter
@NoArgsConstructor
public class SaleSuccessDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String sellerName;
    private Long visited;
    private Long deals;

    public SaleSuccessDTO(Seller seller, Long visited, Long deals) {
        sellerName = seller.getName();
        this.visited = visited;
        this.deals = deals;
    }
}
