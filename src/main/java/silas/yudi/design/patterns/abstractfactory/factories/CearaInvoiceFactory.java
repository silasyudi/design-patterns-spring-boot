package silas.yudi.design.patterns.abstractfactory.factories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import silas.yudi.design.patterns.abstractfactory.services.invoices.CearaInvoiceService;
import silas.yudi.design.patterns.abstractfactory.services.invoices.InvoiceService;
import silas.yudi.design.patterns.abstractfactory.services.taxes.CearaTaxService;
import silas.yudi.design.patterns.abstractfactory.services.taxes.TaxService;
import silas.yudi.design.patterns.domain.constants.State;

@Component
@Qualifier("CE")
public class CearaInvoiceFactory implements InvoiceAbstractFactory {

    @Override
    public TaxService getTaxService() {
        return new CearaTaxService();
    }

    @Override
    public InvoiceService getInvoiceService() {
        return new CearaInvoiceService();
    }

    @Override
    public State getState() {
        return State.CE;
    }
}
