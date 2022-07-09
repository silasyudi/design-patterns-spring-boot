package silas.yudi.design.patterns.abstractfactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import silas.yudi.design.patterns.domain.entities.Invoice;
import silas.yudi.design.patterns.domain.entities.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class InvoiceGeneratorWithQualifierTest {

    @Autowired
    private InvoiceGeneratorWithQualifier invoiceGenerator;

    @Test
    public void shouldDoGetInvoiceFromParaiba() {
        Product product = Product.builder().salePrice(100.0).build();
        Invoice invoice = invoiceGenerator.generate(product);
        assertTrue(invoice.getId().startsWith("PB"));
        assertEquals(10.0, invoice.getTaxValue());
    }
}
