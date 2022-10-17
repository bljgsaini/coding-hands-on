package designPattern.behavioral.chainOfResponsibility.example1;

public class Driver {

    public static void main(String[] args) {

        DocumentHandler documentHandler = new SliderDocumentHandler(new PDFDocumentHandler(new TextDocumentHandler(null)));

        documentHandler.openDocument("txt");

        documentHandler.openDocument("ppt");

        documentHandler.openDocument("pdf");

    }

}
