package silas.yudi.design.patterns.templatemethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PdfMakerTest {

    @Test
    public void testBluePdf() {
        String rawResult = (new BluePdfTemplate()).makePage();
        assertEquals("Page A4; Font Size 12; Blue Bg; Family Arial", rawResult);
    }

    @Test
    public void testRedPdf() {
        String rawResult = (new RedPdfTemplate()).makePage();
        assertEquals("Page A4; Font Size 12; Red Bg; Family Arial", rawResult);
    }
}
