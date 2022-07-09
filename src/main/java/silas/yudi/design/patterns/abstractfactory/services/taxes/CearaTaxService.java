package silas.yudi.design.patterns.abstractfactory.services.taxes;

import silas.yudi.design.patterns.domain.entities.Product;

public class CearaTaxService implements TaxService {

    @Override
    public Double getTax(Product product) {
        return product.getSalePrice() * 0.09;
    }
}
