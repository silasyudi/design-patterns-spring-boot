package silas.yudi.design.patterns.abstractfactory;

import org.springframework.stereotype.Component;
import silas.yudi.design.patterns.abstractfactory.factories.InvoiceAbstractFactory;
import silas.yudi.design.patterns.domain.constants.State;
import silas.yudi.design.patterns.domain.entities.Invoice;
import silas.yudi.design.patterns.domain.entities.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class InvoiceGeneratorWithStrategy {

    private final Map<State, InvoiceAbstractFactory> invoiceFactories;

    public InvoiceGeneratorWithStrategy(Set<InvoiceAbstractFactory> factories) {
        this.invoiceFactories = new HashMap();
        factories.forEach(factory -> invoiceFactories.put(factory.getState(), factory));
    }

    public Invoice generate(Product product) {
        InvoiceAbstractFactory factory = invoiceFactories.get(product.getState());
        Double taxValue = factory.getTaxService().getTax(product);
        return factory.getInvoiceService().registerInvoice(taxValue);
    }
}
