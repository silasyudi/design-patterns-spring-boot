package silas.yudi.design.patterns.abstractfactory.factories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import silas.yudi.design.patterns.abstractfactory.services.invoices.InvoiceService;
import silas.yudi.design.patterns.abstractfactory.services.invoices.ParaibaInvoiceService;
import silas.yudi.design.patterns.abstractfactory.services.taxes.ParaibaTaxService;
import silas.yudi.design.patterns.abstractfactory.services.taxes.TaxService;
import silas.yudi.design.patterns.domain.constants.State;

@Component
@Qualifier("PB")
public class ParaibaInvoiceFactory implements InvoiceAbstractFactory {

    @Override
    public TaxService getTaxService() {
        return new ParaibaTaxService();
    }

    @Override
    public InvoiceService getInvoiceService() {
        return new ParaibaInvoiceService();
    }

    @Override
    public State getState() {
        return State.PB;
    }
}
