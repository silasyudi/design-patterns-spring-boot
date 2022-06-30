package silas.yudi.design.patterns.templatemethod;

public class RedPdfTemplate extends PdfMaker {

    @Override
    protected String backgroundColor() {
        return "Red";
    }
}
