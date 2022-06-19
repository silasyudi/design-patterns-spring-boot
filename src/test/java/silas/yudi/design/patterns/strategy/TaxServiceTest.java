package silas.yudi.design.patterns.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import silas.yudi.design.patterns.strategy.constants.State;
import silas.yudi.design.patterns.strategy.entities.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class TaxServiceTest {

    private Product product;

    @Autowired
    private TaxService service;

    @BeforeEach
    public void setup() {
        product = Product.builder().salePrice(100.0).build();
    }

    @Test
    public void shouldReturnNinePercentOfTaxCearaState() {
        product.setState(State.CE);
        Double taxValue = service.calculateTaxOnProduct(product);
        assertEquals(9.0, taxValue);
    }

    @Test
    public void shouldReturnTenPercentOfTaxParaibaState() {
        product.setState(State.PB);
        Double taxValue = service.calculateTaxOnProduct(product);
        assertEquals(10.0, taxValue);
    }

    @Test
    public void shouldReturnElevenPercentOfTaxPernambucoState() {
        product.setState(State.PE);
        Double taxValue = service.calculateTaxOnProduct(product);
        assertEquals(11.0, taxValue);
    }

    @Test
    public void shouldThrowErrorOnUnsupportedState() {
        product.setState(State.PI);
        assertThrows(
                IllegalArgumentException.class,
                () -> service.calculateTaxOnProduct(product)
        );
    }
}
