package silas.yudi.design.patterns.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import silas.yudi.design.patterns.domain.constants.State;

@Getter
@Setter
@Builder
public class Product {

    private State state;

    private Double salePrice;
}
