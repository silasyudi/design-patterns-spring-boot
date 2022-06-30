package silas.yudi.design.patterns.templatemethod;

public class BluePdfTemplate extends PdfMaker {

    @Override
    protected String backgroundColor() {
        return "Blue";
    }
}
