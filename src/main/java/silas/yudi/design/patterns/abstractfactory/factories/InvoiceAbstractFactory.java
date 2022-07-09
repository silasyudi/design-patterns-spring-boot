package silas.yudi.design.patterns.abstractfactory.factories;

import silas.yudi.design.patterns.abstractfactory.services.invoices.InvoiceService;
import silas.yudi.design.patterns.abstractfactory.services.taxes.TaxService;
import silas.yudi.design.patterns.domain.constants.State;

public interface InvoiceAbstractFactory {

    TaxService getTaxService();

    InvoiceService getInvoiceService();

    State getState();
}
