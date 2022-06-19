package silas.yudi.design.patterns.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import silas.yudi.design.patterns.strategy.constants.State;
import silas.yudi.design.patterns.strategy.entities.Product;
import silas.yudi.design.patterns.strategy.strategies.TaxStrategy;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

@Service
public class TaxService {

    public final HashMap<State, TaxStrategy> taxStrategies;

    @Autowired
    public TaxService(Set<TaxStrategy> taxStrategySet) {
        taxStrategies = new HashMap<>();
        taxStrategySet.forEach(taxStrategy -> taxStrategies.put(taxStrategy.getState(), taxStrategy));
    }

    public Double calculateTaxOnProduct(Product product) {
        TaxStrategy strategy = taxStrategies.get(product.getState());

        if (Objects.isNull(strategy)) {
            throw new IllegalArgumentException("State " + product.getState() + " not supported");
        }

        return strategy.calculateTaxOnSalePrice(product.getSalePrice());
    }
}
