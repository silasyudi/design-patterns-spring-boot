package silas.yudi.design.patterns.abstractfactory.services.invoices;

import silas.yudi.design.patterns.domain.entities.Invoice;

import java.util.Random;

import static silas.yudi.design.patterns.domain.constants.State.CE;

public class CearaInvoiceService implements InvoiceService {

    @Override
    public Invoice registerInvoice(Double taxValue) {
        return Invoice.builder()
                .id(CE.name() + (new Random()).nextLong())
                .taxValue(taxValue)
                .build();
    }
}
