package silas.yudi.design.patterns.abstractfactory.services.taxes;

import silas.yudi.design.patterns.domain.entities.Product;

public interface TaxService {

    Double getTax(Product product);
}
