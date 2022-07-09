package silas.yudi.design.patterns.abstractfactory.services.invoices;

import silas.yudi.design.patterns.domain.entities.Invoice;

public interface InvoiceService {

    Invoice registerInvoice(Double taxValue);
}
