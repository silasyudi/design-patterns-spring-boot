package silas.yudi.design.patterns.strategy.strategies;

import silas.yudi.design.patterns.strategy.constants.State;

public interface TaxStrategy {

    Double calculateTaxOnSalePrice(Double salePrice);

    State getState();
}
