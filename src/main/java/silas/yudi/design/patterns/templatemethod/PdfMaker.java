package silas.yudi.design.patterns.templatemethod;

public abstract class PdfMaker {

    final public String makePage() {
        String pageSize = "Page " + pageSize();
        String fontSize = "Font Size " + fontSize();
        String backgroundColor = backgroundColor() + " Bg";
        String fontFamily = "Family " + fontFamily();
        return String.format("%s; %s; %s; %s", pageSize, fontSize, backgroundColor, fontFamily);
    }

    private String pageSize() {
        return "A4";
    }

    private String fontSize() {
        return "12";
    }

    abstract protected String backgroundColor();

    private String fontFamily() {
        return "Arial";
    }
}
