package silas.yudi.design.patterns.abstractfactory.services.invoices;

import silas.yudi.design.patterns.domain.entities.Invoice;

import java.util.Random;

import static silas.yudi.design.patterns.domain.constants.State.PB;

public class ParaibaInvoiceService implements InvoiceService {

    @Override
    public Invoice registerInvoice(Double taxValue) {
        return Invoice.builder()
                .id(PB.name() + (new Random()).nextLong())
                .taxValue(taxValue)
                .build();
    }
}
