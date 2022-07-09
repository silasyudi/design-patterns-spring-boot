package silas.yudi.design.patterns.abstractfactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import silas.yudi.design.patterns.abstractfactory.factories.InvoiceAbstractFactory;
import silas.yudi.design.patterns.domain.entities.Invoice;
import silas.yudi.design.patterns.domain.entities.Product;

@Component
public class InvoiceGeneratorWithQualifier {

    private final InvoiceAbstractFactory invoiceFactory;

    public InvoiceGeneratorWithQualifier(@Qualifier("PB") InvoiceAbstractFactory invoiceFactory) {
        this.invoiceFactory = invoiceFactory;
    }

    public Invoice generate(Product product) {
        Double taxValue = invoiceFactory.getTaxService().getTax(product);
        return invoiceFactory.getInvoiceService().registerInvoice(taxValue);
    }
}
