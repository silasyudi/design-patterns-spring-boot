package silas.yudi.design.patterns.strategy.strategies;

import org.springframework.stereotype.Component;
import silas.yudi.design.patterns.strategy.constants.State;

@Component
public class CearaTaxStrategy implements TaxStrategy {

    @Override
    public Double calculateTaxOnSalePrice(Double salePrice) {
        return salePrice * 0.09;
    }

    @Override
    public State getState() {
        return State.CE;
    }
}
